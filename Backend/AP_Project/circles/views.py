from rest_framework import generics, permissions, mixins
from rest_framework.authentication import SessionAuthentication, BasicAuthentication, TokenAuthentication

from .models import Circle
from .serializers import CircleSerializer
from django.views.decorators.csrf import csrf_exempt
from rest_framework.views import APIView
from rest_framework.response import Response
from circles.permissions import IsOwnerOrReadOnly

class CircleList(generics.ListCreateAPIView):
    authentication_classes = (TokenAuthentication,)
    queryset = Circle.objects.all()
    serializer_class = CircleSerializer
    permission_classes = (permissions.IsAuthenticatedOrReadOnly,IsOwnerOrReadOnly) # new

    def post(self, request, *args, **kwargs):
        return self.create(self.request)


    def perform_create(self, serializer):
        serializer.save(createdBy=self.request.user)




class CircleDetail(generics.RetrieveUpdateDestroyAPIView):
    authentication_classes = (TokenAuthentication,)
    queryset = Circle.objects.all()
    serializer_class = CircleSerializer
    permission_classes = (permissions.IsAuthenticatedOrReadOnly,) # new

    # def perform_update(self, serializer):
    #
    #     serializer.save(createdBy=self.request.user)

    # def update(self, request, *args, **kwargs):
    #     instance = self.get_object()

    # def update(self, request, *args, **kwargs):
    #     print("views")
    #     instance = self.get_object()
    #     members = request.data.get('members')
    #     print(instance)
    #     print(members)