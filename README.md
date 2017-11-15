# rest_services
Create REST API to get playlist items by playlist id with Spring Boot without oAuth

#Steps
1. Create Playlist (i.e name - my_music ) in your youtube account, create access key required to access youtube API
2. Add videos to the above playlist on youtube console
3. Fetch video metedata by playlist Id using /playlistitems API
4. Transform json object received from youtube to Wynk object (i.e title, createdDate, streamUrl) and return it.

Refer to doc - https://developers.google.com/youtube/v3/docs/playlistItems

#How to get PlayListId

After creating playList when you click on your playList, you will see this kind of URL :

https://www.youtube.com/playlist?list=PLcBxRqzKd0mm13DdfbqNRhDl2RBsp2-de

value in list as query param denotes playListId (PLcBxRqzKd0mm13DdfbqNRhDl2RBsp2-de)


