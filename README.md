# SpeakerWyr

"SpeakerWire: Where Speakers Connect"

- Final Project for Fall 2019 Java Cohort at We Can Code IT, Columbus, OH

- By Luke Brannigan, Brian Bross, Brendin Headlee, and Barbara Taylor

This application allows people who are hosting events ("Events") in the community ("Hosts") to connect with speakers ("Speakers") who are offering talks ("Talks") to deliver. 

We have a landing page where Hosts and Speakers can log in to the site. From there, they can do the following:

Hosts can: 
- Log in
- Search for a talk, with the following parameters:
--- Genre(s) (subject)
--- Tag(s) (descriptive adjectives)
--- Duration: 15 min, 15-30 min, 30-60 min, or >60 min
--- Name of Speaker
- Connect with a Speaker
- Book a Speaker
- Keep track of Events that they are hosting, and whether an Event is "PENDING", "BOOKED", or "DONE"

Speakers can:
- Log in
- Upload each Talk they wish to offer, includint the Talk's:
--- Title
--- Duration
--- Description
--- Genre(s)
--- Tag(s)
--- Video of the Talk
- Search for an Event, with the following parameters:
--- Genre (subject)
--- Tags (descriptive adjectives)
- Connect with a Host
- Book an Event
- Keep track of Events that they are speaking at, and whether an Event is "PENDING", "BOOKED", or "DONE"

Hosts have the following descriptors:
- Name
- Location
- Bio
- Headshot
- List of Event(s) they are hosting

Speakers have the following descriptors:
- Name
- Location
- Bio
- Headshot
- List of Talk(s) they are offering

Talks have the following characteristics:
- Speaker
- Title
- Description
- Duration
- Video (iframe)
- Genre(s)
- Tag(s)
- Potentially, an Event scheduled with that Talk

Events have the following characteristics:
- Host
- Title
- Date
- Location
- Duration
- Genre(s)
- Status: "PENDING", "BOOKED", or "DONE"
- Potentially, a list of associated Talks

Genres have the following characteristics:
- Name
- List of associated Talks

Tags have the following characteristics:
- Name
- List of associated Talks



Built with:
- Java
- HTML
- CSS
- Thymeleaf