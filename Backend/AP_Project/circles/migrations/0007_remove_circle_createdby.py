# Generated by Django 2.2 on 2019-04-28 16:50

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('circles', '0006_auto_20190428_1648'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='circle',
            name='createdBy',
        ),
    ]
