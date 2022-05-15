Milestone 1:

So far for our project, we have two main ideas we plan to pick from after getting more feedback from the TA:

Our first idea is a program that keeps track of how much resources another program's classes use through analysis of its code. We plan to visualize this via graphs, and we can separate each class of the program into a graph and be able to compare the amount of memory used, as well as potentially other metrics for these classes, such as network utilization.

Our second idea is a UML class diagram generator, where we would be able to generate visualizations of the connections between classes and what they contain as a UML class diagram based off of a program's code.

For both of our ideas, we plan to still use the same programming language that this group is already familiar with, and that is Java. Plus, we feel like we haven't learned enough about the material of "program analysis", and therefore won't be able to make any further judgement or planning until we feel confident enough in the upcoming weeks.

Milestone 2:

Summary of progress so far:

After talking with our TA Nico, we decided to proceed with the UML diagram generator, since the other two ideas could either be too difficult to implement, or the other way around, too easy and simple to implement.

We have chosen our language to write our program analysis in Java just like we did in Project 1. Everything will be done in Java, including the GUI (JSwing).

In terms of coding progress we have not started coding. We finished dividing up responsibilities and are figuring out the structure of our project.

Division of responsibilities:

Front-End: Bill and Felix

Responsibilities will include creating the visualization of the UML diagram of our program analysis, although we haven't fully decided yet about which Java library we're going to use. But it's likely going to be the Java SWING again since this is what our group is familiar with.

Back-End: Jaskaran, Sahib and Jenny

Responsibilities will include implementing the tokenizer, parser, visitor patterns, and other program analyses functionality of our language.

These are the main division of roles that we agreed on. The responsibilities are pretty general as of now but our next step is to figure out what exactly each individual is working on.

Roadmap:

For our roadmap, we want to confirm what features we want to focus on and implement first. This should be done in the next couple of days so we can start organizing the structure of our project, the specific tasks each individual does, and start coding.

Milestone 3:

For the upcoming week we will start thinking about the actual implementation and make planning for the coding with Jenny/Sahib/Jaskaran doing the front end and Bill/Felix doing the front-end. We will take into account the feedback received from our first user studies.

We conducted a user study with a first year CPSC student at UBC. They have coded in Java before but did not completely understand the concept of UML diagrams, so we thought this program could also be helpful for new users since they wouldn’t be able to make UML diagrams themselves.

After a quick explanation of UML diagrams and what our program aims to do, we gave them a sample of what our program might output and asked them to identify possible issues with the code that produced this output and changes that can be made.

The sample output provided to the user is available in the repository.

The user was able to identify all the issues as outlined by the sample output. 
They identified that RemoveTheProductFromShoppingCart() and SignUpForMembershipWithStore() could benefit from different function names, they identified that getStoreLocation() could be refactored out of the Orders class, and they identified that Customer didn’t need to implement Dolphin.

We then asked the user if they had any feedback on potential changes. They said that although they were able to identify all the issues outlined by the sample output, “if you didn’t tell me what the color coding meant beforehand I wouldn’t have been able to point out all the problems in the code.”

In response for this feedback, a better idea for the output might be to have the class nodes also be buttons that the user can click on and expand the window to include more detailed information (Ex. “<function name> could possibly benefit from being refactored”, or “<function name> could benefit from a different name”)

Milestone 4:

Status of implementation: 
- We're now beginning to plan our code and starting to work on the project after finishing our first user studies.

Plans for final user study: 
- We will conduct our final user study once our project is done to get a feedback from our user. The questions that we ask will be similar to our first user study, but this time, we will also do a demo and ask them to try out the program.

Planned timeline for the remaining days:
- Nothing special, just coding for the remaining days, then make the video and conduct the user study possibly 2 or 3 days before the deadline.
