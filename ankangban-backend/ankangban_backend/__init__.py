from flask import Flask

from .extensions import db, migrate, jwt
from .routes.auth import auth_bp
from .routes.family import family_bp
from .routes.backup import backup_bp


def create_app(config_object: str | None = None) -> Flask:
    app = Flask(__name__)

    if config_object is not None:
        app.config.from_object(config_object)
    else:
        app.config.from_mapping(
            SECRET_KEY="change-me-in-production",
            JWT_SECRET_KEY="change-me-too",
            # Use SQLite for easier local development without MySQL setup
            SQLALCHEMY_DATABASE_URI="sqlite:///ankangban.db",
            SQLALCHEMY_TRACK_MODIFICATIONS=False,
        )

    db.init_app(app)
    migrate.init_app(app, db)
    jwt.init_app(app)

    app.register_blueprint(auth_bp, url_prefix="/api/auth")
    app.register_blueprint(family_bp, url_prefix="/api/family")
    app.register_blueprint(backup_bp, url_prefix="/api/backup")

    @app.route("/")
    def index():
        return "Hello! AnKangBan Backend is running successfully!", 200

    return app
