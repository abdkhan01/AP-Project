from django.urls import path
from rest_framework.urlpatterns import format_suffix_patterns
from circles import views, serializers

urlpatterns = [
    path('circles/', views.CircleList.as_view()),
    path('circles/<int:pk>/', views.CircleDetail.as_view())
]

urlpatterns = format_suffix_patterns(urlpatterns)