from django.db import models
from django.contrib.auth.models import User


class Item(models.Model):

    author = models.ForeignKey(User, on_delete=models.CASCADE)
    author_name = models.CharField(max_length=70, default="not provided")
    category = models.CharField(max_length=70)
    title = models.CharField(max_length=70)
    content = models.CharField(max_length=300)
    price = models.IntegerField()
    address = models.CharField(max_length=70)
    photo = models.ImageField(null=True, blank=True, upload_to="images/")

    def __str__(self):
        return self.name