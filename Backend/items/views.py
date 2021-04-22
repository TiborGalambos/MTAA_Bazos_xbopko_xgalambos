from rest_framework.response import Response
from items.serializers import *
from django.db.models import Q


# Creating new Item
class AddItem_API(generics.CreateAPIView):
    permission_classes = [permissions.IsAuthenticated]
    serializer_class = ItemSerializer

    def post(self, request, *args, **kwargs):
        # Adding user id to the post data, duplicating the data and
        # parsing post_values to serializer

        user = request.user
        post_values = request.POST.copy()
        try:
            photo = request.FILES['photo']
        except:
            photo = None

        post_values['author'] = user.id
        post_values['author_name'] = user.username
        post_values['photo'] = photo

        serializer = self.get_serializer(data=post_values)
        serializer.is_valid(raise_exception=True)
        item = serializer.save()

        return Response(serializer.data)


class GetAllItems_API(generics.RetrieveAPIView):
    permission_classes = [permissions.AllowAny]

    # Returning all Items
    def get(self, request, *args, **kwargs):
        # items = Item.objects.all()
        items = Item.objects.order_by('-id')
        serializer = ItemSerializer(items, many=True)

        return Response({'items': serializer.data})


# Returning one item by ID
class GetItemByID_API(generics.RetrieveAPIView):
    permission_classes = [permissions.IsAuthenticated]
    serializer_class = ItemSerializer

    def get(self, request, *args, **kwargs):
        itemid = self.kwargs['itemid']
        items = Item.objects.filter(id=itemid)
        serializer = ItemSerializer(items, many=True)

        return Response(serializer.data[0])


# Return all My Items
class MyItems_API(generics.RetrieveAPIView):
    permission_classes = [permissions.IsAuthenticated]
    serializer_class = ItemSerializer

    def get(self, request, *args, **kwargs):
        user = request.user
        #items = Item.objects.filter(author=user.id)
        items = Item.objects.filter(author=user.id).order_by('-id')
        serializer = ItemSerializer(items, many=True)
        return Response({'items': serializer.data})


# Update info about Item by ID
class UpdateItem_API(generics.UpdateAPIView):
    permission_classes = [permissions.IsAuthenticated]
    serializer_class = ItemSerializer

    def put(self, request, *args, **kwargs):
        itemid = self.kwargs['itemid']
        user = request.user

        put_values = request.POST.copy()
        put_values['author'] = user.id
        try:
            item = Item.objects.get(id=itemid)
        except:
            return Response("Item not found", status=404)

        if item.author_id != user.id:
            return Response("You are not Authorized to delete this", status=401)

        serializer = ItemSerializer(item, data=put_values)
        serializer.is_valid(raise_exception=True)
        serializer.save()

        return Response(serializer.data)


# Delete Item
class DeleteItem_API(generics.DestroyAPIView):
    permission_classes = [permissions.IsAuthenticated]
    serializer_class = ItemSerializer

    def delete(self, request, *args, **kwargs):
        itemid = self.kwargs['itemid']
        try:
            item = Item.objects.get(id=itemid)
        except:
            return Response("Item not found", status=404)
        user = request.user


        if item.author_id != user.id:
            return Response("You are not Authorized to delete this", status=401)
        item.photo.delete(save=True)
        item.delete()

        return Response({"message": "Item deleted"}, status=200)


# Returning all Items by filtering out title OR content that contains the text that was typed into search bar
class GetAllItemsBySearch_API(generics.RetrieveAPIView):
    permission_classes = [permissions.AllowAny]

    def post(self, request, *args, **kwargs):

        s = request.POST.get("query", default=None)
        print(s)
        items = Item.objects.all().filter(Q(content__contains=s) | Q(title__contains=s))

        serializer = ItemSerializer(items, many=True)

        return Response({'items': serializer.data})


# Returning all Items by filtering out by strictly specified category
class GetAllItemsByCategory_API(generics.RetrieveAPIView):
    permission_classes = [permissions.AllowAny]

    def post(self, request, *args, **kwargs):

        s = request.POST.get("query")
        print(s)
        items = Item.objects.all().filter(category=s)

        serializer = ItemSerializer(items, many=True)

        return Response({'items': serializer.data})
