from rest_framework import generics, permissions
from rest_framework import serializers
from django.contrib.auth.models import User
from items.models import Item

# Item Serializer
class ItemSerializer(serializers.ModelSerializer):
  class Meta:
    model = Item
    fields = '__all__'

