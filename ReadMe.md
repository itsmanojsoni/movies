#Project 1 -  "Movies"

Movies android app shows the latest movies currently playing in theaters. The app 
utilizes the Movie Database API to display images and basic information about 
these movies to the user.


Time Spent: 17 hours spent in total

## User Stories
The following required functionality are completed:

[X] User can scroll through current movies from the Movie Database API
[X] Layout is optimized with the [ViewHolder]
(http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView
#improving-performance-with-the-viewholder-pattern) pattern.
[X] For each movie displayed, user can see the following details:
[X] Title, Poster Image, Overview (Portrait mode)
[X] Title, Backdrop Image, Overview (Landscape mode)


The following optional features are implemented:
[X] Display a nice default placeholder (did not get enough time to make it look nicer)
[X] Allow user to view details of the movie including ratings and popularity within 
a separate activity or dialog fragment. 

I would love to implement following things to improve the app. 
1. Improve the UX design. Make fonts look colorful and optimize margins to make things look better.
2. Use Caching to improve loading of images. 
3. Download high resolution image and then scale it down to the half of the screen width 
and height based on the aspect ratio of the original image. 
4. Detail Screen needs quite a bit of improvement. Would like to show ratings 
and popularity in stars and percentage. Would like to show more things like 
release Data, Genre etc. 
5. Would like to enable video playback functionality when user clicks on the video. 
6. Would love to complete remaining user stories. 



#Video WalkThrough

https://github.com/itsmanojsoni/movies/blob/master/codePathAssignmentMovies.mp4

## Open-source libraries used

- Retrofit, GsonParser,
- Glide for Images


## License

    Copyright [2017] [Manoj Soni]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
