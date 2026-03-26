from flask import Blueprint, jsonify, request
from werkzeug.security import check_password_hash, generate_password_hash
from flask_jwt_extended import create_access_token

from ..extensions import db
from ..models import User

auth_bp = Blueprint("auth", __name__)


@auth_bp.post("/register")
def register():
    data = request.get_json(silent=True) or {}
    phone = data.get("phone")
    password = data.get("password")

    if not phone or not password:
        return jsonify({"code": 1, "message": "手机号和密码不能为空"}), 400

    if User.query.filter_by(phone=phone).first():
        return jsonify({"code": 2, "message": "该手机号已注册"}), 400

    user = User(phone=phone, password_hash=generate_password_hash(password))
    db.session.add(user)
    db.session.commit()

    access_token = create_access_token(identity=user.id)
    return jsonify({"code": 0, "message": "注册成功", "data": {"user_id": user.id, "token": access_token}})


@auth_bp.post("/login")
def login():
    data = request.get_json(silent=True) or {}
    phone = data.get("phone")
    password = data.get("password")

    if not phone or not password:
        return jsonify({"code": 1, "message": "手机号和密码不能为空"}), 400

    user = User.query.filter_by(phone=phone).first()
    if not user or not check_password_hash(user.password_hash, password):
        return jsonify({"code": 2, "message": "手机号或密码错误"}), 401

    access_token = create_access_token(identity=user.id)
    return jsonify({"code": 0, "message": "登录成功", "data": {"user_id": user.id, "token": access_token}})


