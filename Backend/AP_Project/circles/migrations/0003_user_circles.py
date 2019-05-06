# Generated by Django 2.2 on 2019-04-23 22:29

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('circles', '0002_auto_20190423_2141'),
    ]

    operations = [
        migrations.CreateModel(
            name='User_Circles',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('circle_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='circleId', to='circles.Circle')),
                ('user_email', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='circle_emails', to=settings.AUTH_USER_MODEL)),
            ],
        ),
    ]
