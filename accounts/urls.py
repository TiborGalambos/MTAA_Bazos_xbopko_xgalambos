from knox import views as knox_views
from .views import LoginAPI, Register, UserAPI
from django.urls import path

urlpatterns = [
    path('register/', Register.as_view(), name='register'),
    path('user/login/', LoginAPI.as_view(), name='login'),
    path('user/logout/', knox_views.LogoutView.as_view(), name='logout'),
    path('api/user/', UserAPI.as_view(), name='user'),
]