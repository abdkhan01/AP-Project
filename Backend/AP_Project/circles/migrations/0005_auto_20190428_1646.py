# Generated by Django 2.2 on 2019-04-28 16:46

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('circles', '0004_remove_circle_circle_id'),
    ]

    operations = [
        migrations.CreateModel(
            name='UserCircles',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
            ],
        ),
        migrations.RemoveField(
            model_name='circle',
            name='owner_email',
        ),
        migrations.AddField(
            model_name='circle',
            name='createdBy',
            field=models.ForeignKey(default=0, on_delete=django.db.models.deletion.CASCADE, related_name='username+', to=settings.AUTH_USER_MODEL),
            preserve_default=False,
        ),
        migrations.DeleteModel(
            name='User_Circles',
        ),
        migrations.AddField(
            model_name='usercircles',
            name='circle_id',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='circleId', to='circles.Circle'),
        ),
        migrations.AddField(
            model_name='usercircles',
            name='members',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='membersid+', to=settings.AUTH_USER_MODEL),
        ),
    ]
