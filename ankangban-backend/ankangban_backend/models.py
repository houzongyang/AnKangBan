from datetime import datetime

from .extensions import db


class User(db.Model):
    __tablename__ = "users"

    id = db.Column(db.Integer, primary_key=True)
    phone = db.Column(db.String(32), unique=True, nullable=False)
    password_hash = db.Column(db.String(128), nullable=False)
    nickname = db.Column(db.String(64))
    created_at = db.Column(db.DateTime, default=datetime.utcnow)


class FamilyLink(db.Model):
    __tablename__ = "family_links"

    id = db.Column(db.Integer, primary_key=True)
    user_id = db.Column(db.Integer, db.ForeignKey("users.id"), nullable=False)
    relative_id = db.Column(db.Integer, db.ForeignKey("users.id"), nullable=False)
    relation_type = db.Column(db.String(32))
    status = db.Column(db.String(16), default="pending")
    share_prefs_json = db.Column(db.Text)
    created_at = db.Column(db.DateTime, default=datetime.utcnow)


class BackupSnapshot(db.Model):
    __tablename__ = "backup_snapshots"

    id = db.Column(db.Integer, primary_key=True)
    user_id = db.Column(db.Integer, db.ForeignKey("users.id"), nullable=False)
    snapshot_data = db.Column(db.LargeBinary, nullable=False)
    created_at = db.Column(db.DateTime, default=datetime.utcnow)


