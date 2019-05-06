from rest_framework import serializers, permissions
from . import models
import users

class CircleSerializer(serializers.ModelSerializer):


    # members = users.serializers.UserSerializer(read_only=False,required=False)
    # createdBy = users.serializers.UserSerializer(required=False)
    successcode= serializers.IntegerField(default=0)
    class Meta:
        model = models.Circle
        fields = ['id','created', 'circle_name','createdBy','members','successcode']

    # def create(self, validated_data):
    #     print("hello")
    #     print(validated_data)
    #
    #     members = validated_data.pop('members')
    #     circle = models.Circle.objects.create(**validated_data)
    #     return circle

    def update(self, instance, validated_data):
        print("serializer")

        if(validated_data.__contains__('members')):


            members = validated_data.pop('members')
            instance.circle_name = validated_data.get("circle_name", instance.circle_name)

            for member in members:
                instance.members.add(member)
            instance.save()

            return instance

        elif(validated_data.__contains__('createdBy')):
            instance.createdBy = validated_data.get("createdBy", instance.createdBy)
            instance.save()
            return instance

        else:
            instance.circle_name = validated_data.get("circle_name", instance.circle_name)
            instance.save()

            return instance



# class UserCirclesSerializer(serializers.ModelSerializer):
#     class Meta:
#         model = models.UserCircles
#         fields = ('id','circle_id', 'members')