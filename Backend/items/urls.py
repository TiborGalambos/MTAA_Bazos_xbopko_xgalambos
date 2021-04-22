from .views import *
from django.urls import path

urlpatterns = [
    # Add item
    path('item/', AddItem_API.as_view(), name='item'),

    # Get all items
    path('item/all/', GetAllItems_API.as_view(), name='item'),

    # Get item by id(pk)
    path('item/<itemid>/', GetItemByID_API.as_view(), name='itemid'),

    # Get all my items
    path('myitems/', MyItems_API.as_view(), name='item'),

    # Update item
    path('myitems/update/<itemid>/', UpdateItem_API.as_view(), name='item'),

    # Update item
    path('myitems/delete/<itemid>/', DeleteItem_API.as_view(), name='item'),

    # Search item by keyword
    path('search/', GetAllItemsBySearch_API.as_view(), name='item'),

    # Search item by category
    path('category/', GetAllItemsByCategory_API.as_view(), name='item'),
]
