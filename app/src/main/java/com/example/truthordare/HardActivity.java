package com.example.truthordare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HardActivity extends AppCompatActivity {

    private TextView textView;
    private ArrayList<String> contentList = new ArrayList<>();
    private static ArrayList<String> namesList = new ArrayList<>();
    private int contentCounter = 0;
    private static final String TAG = "HardActivity";
    private GestureDetector gestureDetector;
    private ArrayList<Integer> drawableIdList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        textView = findViewById(R.id.hardDisplayTextView);
        Button hardNextButton = findViewById(R.id.hardNextButton);
        namesList = getIntent().getStringArrayListExtra("HARD_NAMES_LIST");
        gestureDetector = new GestureDetector(this, new GestureListener());
        loadDrawableIdList();
        loadContentList(getRandomPerson(namesList));
        textView.setText(getRandomContent(contentList));
        hardNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextContentDisplay();
            }
        });
        Log.d(TAG, "onCreate: out");
    }

    @Override
    public void onBackPressed(){}

    private int getRandomDrawableFile(ArrayList<Integer> drawablesIdList){
        Random random = new Random();
        return drawablesIdList.get(random.nextInt(drawablesIdList.size()));
    }

    private String getRandomPerson(ArrayList<String> stringArrayList){
        Random random = new Random();
        return stringArrayList.get(random.nextInt(stringArrayList.size()));
    }

    private String getRandomContent(ArrayList<String> stringArrayList){
        Random random = new Random();
        Collections.shuffle(stringArrayList, random);
        return stringArrayList.get(random.nextInt(stringArrayList.size()));
    }

    private void nextContentDisplay(){
        if(contentCounter < 45){
            loadContentList(getRandomPerson(namesList));
            textView.setBackgroundResource(getRandomDrawableFile(drawableIdList));
            textView.setText(getRandomContent(contentList));
            contentCounter++;
        }else{
            Intent intent = new Intent(HardActivity.this, EndActivity.class);
            startActivity(intent);
        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public void onLongPress(MotionEvent e) {
            Log.d(TAG, "onLongPress: in");
            super.onLongPress(e);
            startActivity(new Intent(HardActivity.this, PopUpActivity.class));
            Log.d(TAG, "onLongPress: out");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void loadDrawableIdList() {
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_green", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_orange", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_pink", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_purple", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_turquoise", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_red", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_blue", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_yellow", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_brick", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_brown", "drawable", this.getPackageName()));
        drawableIdList.add(this.getResources().getIdentifier("rounded_textview_grey", "drawable", this.getPackageName()));
    }


    private void loadContentList(String personName){
        contentList.clear();
        contentList.add("Drink 3 times if you have ever given a massage that turned into something more interesting");
        contentList.add(personName + " for each piece of clothing you take off, give out 1 sip");
        contentList.add("Everyone unbutton your shirts and drink once for each button");
        contentList.add(personName + " choose a person to caress you while you are finishing your drink (the zone is chosen by the others)");
        contentList.add("Drink 3 times if you have ever had more fuck buddies at the same time");
        contentList.add(personName + " choose your drinking bitch. You will be able to transfer your sips to him/her 2 times in this game");
        contentList.add("Drink 3 times if you kissed 2 people in the same night");
        contentList.add("Go around the room and touch the crotch of the person to your right or drink 2 times. " + personName + " starts");
        contentList.add("If you ever cried out the wrong person's name while having sex, drink 4 times");
        contentList.add(personName + " blindfold yourself. 2 players will kiss you anywhere. If you guess one of the two players you can give 4 sips. You have one chance");
        contentList.add(personName + " tell a funny story about a player or drink 2 times");
        contentList.add("If you look people in the eyes while speaking to them, drink one sip (5 rounds)");
        contentList.add("Drink 3 times if your first time was not that good");
        contentList.add("If you ever had sex while you or your partner was on her period, drink 5 times");
        contentList.add(personName + " has to speak with Chinese accent (5 rounds)");
        contentList.add(personName + " drink as many sips as you poured. None ? Drink 3 times for the bartender");
        contentList.add("Girls, the first one to have had her period can give 4 sips");
        contentList.add("Spin the bottle baby! Each player has to spin the bottle and kiss the targeted player (5 sips for refusal). " + personName + " starts");
        contentList.add(personName + " is Cupid! You choose who kisses or hugs who. (3 sips for the person who refused) (5 rounds)");
        contentList.add(personName + " if you have friends to whom you usually speak in a foreign language, give out 3 sips. Drink them otherwise");
        contentList.add(personName + " show your boobs or drink 3 times. If you are a man, you can give out 3 sips");
        contentList.add("If you ever painted your nails, drink 3 times");
        contentList.add("Those who ever faked an orgasm drink 2 times");
        contentList.add("The group choose a player." + personName + " mime a sexual position with that player.(5 sips for the person who refuses)");
        contentList.add("Drink 2 times if you ever fucked in a friend's bed without them finding out");
        contentList.add(personName + " let the player chosen by the group to pinch your nipples or drink 4 times");
        contentList.add("What is arousing your partner ? (first to repeat or cannot find anything has to drink 3 times)" + personName + " starts");
        contentList.add("If you ever had sex despite friends sleeping in the same room, give out 3 sips");
        contentList.add("'Typical places for fantasies'. " + personName + " , you start. (first to repeat or cannot find anything has to drink 2 times)");
        contentList.add(personName + ", ask a question to the room in large. The first person who tell you the answer can give out 3 sips, the rest drink one sip");
        contentList.add(personName + " go around the room and tap the back of the player who must take 2 sips");
        contentList.add("The lovely person hosting this game gives out 2 sips");
        contentList.add(personName + " if you manage to kiss a player anywhere without forcing them, this player will finish their drink. You have 5 minutes ");
        contentList.add(personName + " has to pause 2 seconds between each spoken word. Drink once every time you forget to pause. (5 rounds)");
        contentList.add("If you ever had orgasm drink 3 times");
        contentList.add("Things to do when nobody is home. " + personName + " you start. (first to repeat or cannot find anything has to drink 2 times)");
        contentList.add("Things to do before going out when you are single. " + personName + " you start. (first to repeat or cannot find anything has to drink 2 times)");
        contentList.add("Players have ever dreamt about fighting someone drink 2 times");
        contentList.add("The group has to choose a player. " + personName + ", kiss the chosen player on the neck or drink 4 times (be sensual)");
        contentList.add("Smokers who have ever tried to stop smoking but failed, drink 3 times");
        contentList.add("The last person to have performed passionate cunnilingus, gives out 4 sips");
        contentList.add("If you ever thought of someone else during sex, drink 3 times");
        contentList.add("Drink 5 times if you have ever been pulled over by the police");
        contentList.add(personName + ", choose someone to cup your ass with their hands");
        contentList.add("'Sexual practices other than penetration'. (first to repeat or cannot find anything has to drink 2 times). " + personName + " you start");
        contentList.add("Give out 5 sips if you have ever masturbated at work");
        contentList.add("New rule, each time someone talks, he/she has to begin the sentence with 'but sir,...'");
        contentList.add("Male panties contest. Girls, you are the jury. Loser get 3 sips");
        contentList.add("The group has to choose two players (male and female) who will finish their drinks and kiss each other");
        contentList.add("Kiss party. Go around the room and kiss the person to the right or drink 4 times." + personName + " you start");
        contentList.add(personName + " you can give out as many sips as you have uncles");
        contentList.add(personName + " and the player in front of him/her has to tell us a bedroom fantasy (it does not matter if it happened or not). The player with the most interesting one can give out 5 sips to any player");
        contentList.add(personName + " you are a special player. You can rest your feet on the right player lap for 2 rounds and refuse to drink");
        contentList.add("The clock tells you to drink. The first player has to drink the first number of the hour, the second, the second number and so on." + personName + " you start and then everything goes to the right.");
        contentList.add(personName + " let the person in front of you pour ice cubes down your chest, back or butt or all of them");
        contentList.add(personName + " let the person on your left do 5 push-ups with you lying under them (face to face)");
        contentList.add(personName + " transfer an ice cube from the person on your right's mouth to yours");
        contentList.add(personName + " let the person to your right and left give you a wet willy at the same time. 5 sips in case of refusal");
        contentList.add("The group chooses someone who takes part in the game. " + personName + " will be spanked by that person. 3 sips for the person who refuses");
        contentList.add("All the sips get doubled for 5 rounds. Cheers !!");
        contentList.add(personName + " bend at the waist so that you are looking behind you between your legs. Now run backwards until you can tag someone with your butt.3 sips in case of refusal. The person tagged has to drink 6 sips");
        contentList.add(personName + " act like whatever animal someone yells out for the next 3 minutes.3 sips in case of refusal");
        contentList.add("Two sips for everyone in the game !!!");
        contentList.add(personName + " give a sensual neck kiss to the person to your left. 4 sips in case of refusal. If that person enjoyed it, well, have a funny night and give out 5 sips");
        contentList.add(personName + " sit there in nothing but boxers. 3 sips in case of refusal");
        contentList.add("Each player can give out as many sips as clothes taken off of them");
        contentList.add("Girls not wearing a bra can give out 2 sips to men. Cheers !!!");
        contentList.add("Drink if your crush is in this game");
        contentList.add(personName + " blindfold yourself. The group must choose 3 players. If you guess 2 of them just by touching their butts you can give out 5 sips. 4 sips in case of refusal or if you could not guess those 2 players");
        contentList.add("The group choose a song. " + personName + ", you are the stripper tonight. Go dance and take those clothes off. 4 sips in case of refusal");
        contentList.add(personName + " invent a new rule for the rest of the game");
        contentList.add(personName + " each player you can kiss has to finish their drink");
        contentList.add(personName + " yell the first sentence or word that comes into your mind right now");
        contentList.add(personName + " say 'and everything went well' after each sentence until your next turn");
        contentList.add(personName + " put on the bra of the first girl to your right. 3 sips for both of you if one player refuses. Both of you can give out 4 sips if the changing take place in the same room");
        contentList.add("The first who laugh must finish their drink");
        contentList.add(personName + " blindfold yourself. The group pick a player and you have to give that player a lap dance, blindfolded of course. 3 sips if you refuse to complete the dare");
        contentList.add(personName + " pretend to be the person in front of you for 10 minutes");
        contentList.add(personName + " twerk for 1 minute straight. The group pick the music");
        contentList.add(personName + " until the next round, talk super loud, like nobody can hear you. 2 sips in case of refusal");
        contentList.add(personName + " get into a debate with a wall or drink 3 times");
        contentList.add(personName + " take a selfie with the toilet. Give out 4 sips if you post it on your story.");
        contentList.add(personName + " pick the nose of the person next to you.");
        contentList.add(personName + " give everyone in the room a hug.");
        contentList.add(personName + " wear your underwear on the outside of your clothes or drink 4 times");
        contentList.add(personName + " run down the street with a wet T-shirt on. 4 sips in case of refusal. If you are a girl you can give out 5 sips if you complete the challenge without the bra");
        contentList.add(personName + " if you are a man, wear lipstick for the rest of the game. If you are a girl, let a man do your makeup. 4 sips in case of refusal");
        contentList.add(personName + " walk down the street in your underwear or drink 3 times");
        contentList.add(personName + " for the rest of the game you cannot say 'I'. 2 sips for each 'I' you said");
        contentList.add(personName + " walk like a crab for the rest of the game.");
        contentList.add(personName + " watch a porn video from start to the end");
        contentList.add("It is karaoke night." + personName + " has to sing a song chosen by the group");
        contentList.add("The group chooses a player who must shave/wax " + personName + " wherever the group decides. If anyone refuses, both of you must drink 5 times");
        contentList.add(personName + " eat a single spaghetti like in Lady and the Tramp with the person to your left or drink 5 times");
        contentList.add(personName  + " you’re in school, and you’ve been a bad student. For the next round, you’re in time out on someone’s lap. The group chooses the player");
        contentList.add(personName + " with your eyes closed and the other players standing in front you have to move towards them. First player you touch you have to kiss him/her where you touched him/her.");
        contentList.add(personName + " if you are a girls then take off your bra and toss it out the window or drink 3 times. If you are a man, well, drink a sip for each girl at the table");
        contentList.add(personName + " blindfold yourself. A random player will give you a back massage. If you like it you can choose to kiss that player without knowing him/her.");
        contentList.add(personName + " you have to keep your hand on the very inner thigh of the person to your right for the next round or drink 3 times.");
        contentList.add("Have you ever had a crush on a teacher ? Vote at the same time. The winners can give out 2 sips each");
        contentList.add(personName + " go skinny dipping for 2 minutes or drink 2 times");
        contentList.add(personName + " choose a letter. Each player who slept with a person whose name starts with this letter has to drink 2 times");
        contentList.add(personName + " choose someone to show a nipple. 3 sips in case of refusal");
        contentList.add("Go around the room and touch the chest of the person to your right or drink 3 times");
        contentList.add(personName + " if you put on deodorant before coming here, give out 2 sips. Otherwise drink them");
        contentList.add(personName + " choose between kissing someone or drinking 2 times (cheek kiss is also good)");
        contentList.add("From now on, every time a player says a bad word, he/she must take a piece of clothing off");
        contentList.add("Anyone who has used a dating website drink 3 times");
        contentList.add("Drink 5 times if you have ever had sex thanks to a dating website");
        contentList.add("People wearing glasses drink 3 times");
        contentList.add("The first player to find a triangular object in the room gives out 2 sips, no phones allowed");
        contentList.add(personName + " if you know all the names of the person in front of you (first, middle, last), this player will drink 2 times. Otherwise you will drink 3 times");
        contentList.add("Until " + personName + " sees his/her name on the screen, he/she will drink for every new screen");
        contentList.add(personName + " if you are wearing clothes that don't belong to you, give out 3 sips. Otherwise drink them");
        contentList.add("Everyone older than " + personName + " drink 5 times");
        contentList.add(personName + " put on as many clothes as glasses you finished until now");
        contentList.add(personName + " you say 'In my suitcase there is...' and each player has to add a new object after repeating the ones already said. 2 sips in case of a repeated object or forgetting one");
        contentList.add(personName + " give out as many sips as single persons are around the table");
        contentList.add(personName + " if your first time was after 18, give out 3 sips");
        contentList.add(personName + " you are the clock for 5 rounds. Loudly announce the time every minute. Drink once for each minute you forget");
        contentList.add(personName + " you have to keep your hand on the right person thigh for for the next 5 rounds");
        contentList.add(personName + " give out 3 sips if you find yourself attractive, otherwise drink them");
        contentList.add(personName + " choose 2 players who must mime a sexual position and drink at the same time 3 sips");
        contentList.add(personName + "is now forbidden to use personal pronouns until we say so. 1 sip for each mistake");
        contentList.add("When the clock shows a multiple of ten (8:00 8:10 8:20 etc.) the first player who shout 'shit i left my cat back in space' can give out 10 sips");
        contentList.add("FREEZE !!! the last person to stop moving drinks 4 times");
        contentList.add("Give out 3 sips if you french kissed two people in the same night");
        contentList.add("If you cannot touch your toes while having straight legs drink 2 times");
        contentList.add("Places to put your hands during penetration. The first one who runs out of ideas has to drink 3 times. " + personName + " you start.");
        contentList.add("If you like dirty talk drink 3 times");
        contentList.add(personName + " if you smoke, throw a cigarette to the trash or drink 2 times. If you do not smoke give out 5 sips");
        contentList.add(personName + " give a hickey to the person chosen by the group or drink 3 times");
        contentList.add("Foods that give you bad breath. The first who runs out of ideas has to drink 4 times. " + personName + " you start.");
        contentList.add("Things you can find in a purse. The first who runs out of ideas has to drink 4 times. " + personName + " you start.");
        contentList.add("The oldest person in the room must drink 3 sips");
        contentList.add(personName + " transfer an ice cube from your mouth to the mouth of the person sitting in front of you or drink 4 times");
        contentList.add("Morning or night sex ? Everyone vote at the same time, losing group drinks 2 times");
        contentList.add(personName + " challenge someone to unclip a female player's bra. If that person can do it in 5 seconds time, he/she can give out 4 sips otherwise drink them");
        contentList.add("Let's do it again !! Those who have ever kissed each other have to kiss each other again or both drink 3 times");
        contentList.add("New rule !! Everytime we finish our drink we must caress our nipples");
        contentList.add("Girls, take off a piece of clothing or drink 2 times");
        contentList.add("The person the group decides is the most sober must drink 5 times");
        contentList.add(personName + " start drinking. The person to the left follows and so on. Continue drinking until the first person has stopped");
        contentList.add(personName + " drink as many times as you have balls ");
        contentList.add("Give out 3 sips if you have ever had surgery");
        contentList.add(personName + " choose who will drink 3 times from your glass");
        contentList.add(personName + " empty your drink in your panties or in your mouth, it is up to you");
        contentList.add(personName + " is Caesar !! Anytime: thumb up and the targeted person is free from drinking, thumb down and the player doubles");
        contentList.add(personName + " must do a piggyback to the person to his/her right. 3 sips in case of refusal");
        contentList.add(personName + " you are the dictator. You can dare anyone anytime. 3 sips in case of refusal. (5 rounds)");
        contentList.add("The last person to still have their feet on the ground drinks 2 times");
        contentList.add(personName + " add either a mixer or alcohol to the glass of the person in front of you");
        contentList.add("'Blowjob or anal ?' Vote at the same time, losing group drinks 4 times");
        contentList.add("The person to have diluted their drink the most, drink half of it");
        contentList.add(personName + " finish your drink and use the glass to play spin the bottle. Whoever you get, kiss them on the lips");
        contentList.add("Those who have foreplayed before penetration drink 3 times");
        contentList.add("Let's play SPIN THE BOTTLE !!! From now on you can choose to drink or spin a bottle. You must kiss the person targeted by the bottle or double the number of sips");
        contentList.add("The younger player in the room can give out 3 sips");
        contentList.add(personName + " kiss the chest of a player chosen by the group or drink 2 times");
        contentList.add(personName + " give a foot massage to a player chosen by the group or drink 3 times");
        contentList.add("If you ever fucked a minor though you were a major drink 3 times");
    }
}
