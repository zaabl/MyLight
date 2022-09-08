# My Light
An application intended for people with visual impairment to help them by recognizing the objects in front of the camera.

## Overview
The application uses android's speach recognizer to recognize the initial commands, as the user can say the 
key word "What's infront of me?" then the system recognizes the sound then opens the recognizer activity where the camera opens, takes a snap image then here comes the 
Tensorflow lite mission where it recognizes the objects in the image and returns them in an array of objects, then we pass it to the text-to-speach library which in order
converts the specified objects strings and then says it outloud through the phones speakers allowing the user with sight disability to know whats infront of him.



https://user-images.githubusercontent.com/32912214/189239330-4eb4c21c-44d5-4c36-8c60-ca8c34eb9778.mp4

