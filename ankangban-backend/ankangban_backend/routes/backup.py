from flask import Blueprint, jsonify, request

from ..extensions import db
from ..models import BackupSnapshot

backup_bp = Blueprint("backup", __name__)


@backup_bp.post("/upload")
def upload():
    data = request.get_json(silent=True) or {}
    user_id = data.get("user_id")
    snapshot_bytes = (data.get("snapshot") or "").encode("utf-8")

    if not user_id or not snapshot_bytes:
        return jsonify({"code": 1, "message": "参数不完整"}), 400

    snapshot = BackupSnapshot(user_id=user_id, snapshot_data=snapshot_bytes)
    db.session.add(snapshot)
    db.session.commit()

    return jsonify({"code": 0, "message": "备份成功"})


@backup_bp.get("/download")
def download():
    user_id = request.args.get("user_id", type=int)
    if not user_id:
        return jsonify({"code": 1, "message": "参数不完整"}), 400

    snapshot = (
        BackupSnapshot.query.filter_by(user_id=user_id)
        .order_by(BackupSnapshot.created_at.desc())
        .first()
    )
    if not snapshot:
        return jsonify({"code": 2, "message": "暂无备份"}), 404

    return jsonify(
        {
            "code": 0,
            "message": "ok",
            "data": {"snapshot": snapshot.snapshot_data.decode("utf-8")},
        }
    )


