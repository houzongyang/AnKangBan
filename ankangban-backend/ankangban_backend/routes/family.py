from flask import Blueprint, jsonify, request

from ..extensions import db
from ..models import FamilyLink

family_bp = Blueprint("family", __name__)


@family_bp.post("/invite")
def invite():
    data = request.get_json(silent=True) or {}
    user_id = data.get("user_id")
    relative_id = data.get("relative_id")
    relation_type = data.get("relation_type", "")

    if not user_id or not relative_id:
        return jsonify({"code": 1, "message": "参数不完整"}), 400

    link = FamilyLink(
        user_id=user_id,
        relative_id=relative_id,
        relation_type=relation_type,
        status="pending",
        share_prefs_json="{}",
    )
    db.session.add(link)
    db.session.commit()

    return jsonify({"code": 0, "message": "邀请已发送"})


@family_bp.post("/accept")
def accept():
    data = request.get_json(silent=True) or {}
    link_id = data.get("link_id")

    if not link_id:
        return jsonify({"code": 1, "message": "参数不完整"}), 400

    link = FamilyLink.query.get(link_id)
    if not link:
        return jsonify({"code": 2, "message": "不存在的邀请"}), 404

    link.status = "accepted"
    db.session.commit()

    return jsonify({"code": 0, "message": "已接受邀请"})


