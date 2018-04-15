package com.dev.naveen.jokes;

import java.util.Random;

public class Jokes {


    public String getJoke(){
        Random random = new Random();
        int randomNumber = random.nextInt(jokesList.length -1 ) + 1;
        return jokesList[randomNumber];
    }


    private final String[]  jokesList = new String[]{
            "A family of mice were surprised by a big cat. Father Mouse jumped and and said, \"Bow-wow!\" The cat ran away. \"What was that, Father?\" asked Baby Mouse. \"Well, son, that's why it's important to learn a second language.\" ",
            "My friend said he knew a man with a wooden leg named Smith. \n" +
                    "So I asked him \"What was the name of his other leg?\"",
            "The doctor to the patient: 'You are very sick' \n" +
                    "The patient to the doctor: 'Can I get a second opinion?' \n" +
                    "The doctor again: 'Yes, you are very ugly too...'",
            "A man goes to the doctor and says, \"Doctor, wherever I touch, it hurts.\" \n" +
                    "The doctor asks, \"What do you mean?\" \n" +
                    "The man says, \"When I touch my shoulder, it really hurts. If I touch my knee - OUCH! When I touch my forehead, it really, really hurts.\" \n" +
                    "The doctor says, \"I know what's wrong with you - you've broken your finger!\" ",
            "Patient: Doctor, I have a pain in my eye whenever I drink tea. \n" +
                    "Doctor: Take the spoon out of the mug before you drink. ",
            "Patient: Doctor! You've got to help me! Nobody ever listens to me. No one ever pays any attention to what I have to say.\n" +
                    "Doctor: Next please! ",
            "Two boys were arguing when the teacher entered the room.\n" +
                    "The teacher says, \"Why are you arguing?\"\n" +
                    "\n" +
                    "One boy answers, \"We found a ten dollor bill and decided to give it to whoever tells the biggest lie.\"\n" +
                    "\n" +
                    "\"You should be ashamed of yourselves,\" said the teacher, \"When I was your age I didn't even know what a lie was.\"\n" +
                    "\n" +
                    "The boys gave the ten dollars to the teacher.",
            "A snail walks into a bar and the barman tells him there's a strict policy about having snails in the bar and so kicks him out. A year later the same snail re-enters the bar and asks the barman \"What did you do that for?\" ",
            "A: Just look at that young person with the short hair and blue jeans. Is it a boy or a girl? \n" +
                    "B: It's a girl. She's my daughter. \n" +
                    "A: Oh, I'm sorry, sir. I didn't know that you were her father. \n" +
                    "B: I'm not. I'm her mother.",
            "Mother: \"Did you enjoy your first day at school?\" \n" +
                    "Girl: \"First day? Do you mean I have to go back tomorrow? ",
            "Headmaster: I've had complaints about you, Johnny, from all your teachers. What have you been doing? \n" +
                    "Johnny: Nothing, sir. \n" +
                    "Headmaster: Exactly. ",
            "Teacher: \"Nick, what is the past participle of the verb to ring?\" \n" +
                    "Nick: \"What do you think it is, Sir?\" \n" +
                    "Teacher: \"I don't think, I KNOW!\" \n" +
                    "Nick: \"I don't think I know either, Sir!\" ",
            "A: Hey, man! Please call me a taxi. \n" +
                    "B: Yes, sir. You are a taxi. ",
            "A: Why are you crying? \n" +
                    "B: The elephant is dead. \n" +
                    "A: Was he your pet? \n" +
                    "B: No, but I'm the one who must dig his grave. ",
            "A teenage girl had been talking on the phone for about half an hour, and then she hung up.\n" +
                    "\"Wow!,\" said her father, \"That was short. You usually talk for two hours. What happened?\"\n" +
                    "\n" +
                    "\"Wrong number,\" replied the girl.",
            "PUPIL: \"Would you punish me for something I didn`t do?\" \n" +
                    "TEACHER:\" Of course not.\" \n" +
                    "PUPIL: \"Good, because I haven`t done my homework.\"",
            "A teacher asked a student to write 55. \n" +
                    "Student asked: How? \n" +
                    "Teacher: Write 5 and beside it another 5! \n" +
                    "The student wrote 5 and stopped. \n" +
                    "teacher: What are you waiting for? \n" +
                    "student: I don't know which side to write the other 5! ",
            "When I want to teach the coulors, I just ask my students to pretend the phone is ringing and they will answer:\n" +
                    "Phone rings: \"Green, green!\" \n" +
                    "They answer: \"Yellow?\" \n" +
                    "They ask: \"White?\" \n" +
                    "They hang up: \"Pink!\"\n" +
                    "\n" +
                    "While teaching this use your hands pretending you are holding the phone. ",
            "Little Johnny: Teacher, can I go to the bathroom? \n" +
                    "Teacher: Little Johnny, MAY I go to the bathroom? \n" +
                    "Little Johnny: But I asked first! ",
            "Two goldfish in a bowl talking: \n" +
                    "Goldfish 1: Do you believe in God? \n" +
                    "Goldfish 2: Of course, I do! Who do you think changes the water?",
            "Son: Dad, what is an idiot? \n" +
                    "Dad: An idiot is a person who tries to explain his ideas in such a strange and long way that another person who is listening to him can't understand him. Do you understand me? \n" +
                    "Son: No."

    };


}
