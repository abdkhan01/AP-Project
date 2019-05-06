from django.db import models
from users.models import CustomUser
import users

class Circle(models.Model):
    created = models.DateTimeField(auto_now_add=True)
    circle_name = models.CharField(blank=False,max_length=100)
    members = models.ManyToManyField(CustomUser,related_name='circles',blank=True)
    createdBy = models.ForeignKey(users.models.CustomUser,related_name='username+',on_delete=models.CASCADE,blank=True)

    @property
    def successcode(self):
        return 200

    def __str__(self):
        return self.circle_name

