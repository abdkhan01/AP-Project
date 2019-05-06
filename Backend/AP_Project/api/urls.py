from django.urls import include, path

urlpatterns = [
    path('', include('users.urls')),
    path('rest-auth/', include('rest_auth.urls')),
    path('rest-auth/', include('users.urls')),
    path('', include('circles.urls')),  # new

]