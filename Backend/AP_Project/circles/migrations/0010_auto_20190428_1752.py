# Generated by Django 2.2 on 2019-04-28 17:52

from django.conf import settings
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('circles', '0009_circle_members'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='circle',
            name='members',
        ),
        migrations.AddField(
            model_name='circle',
            name='members',
            field=models.ManyToManyField(to=settings.AUTH_USER_MODEL),
        ),
    ]
