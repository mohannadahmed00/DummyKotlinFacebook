package com.example.facebookkotlin

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.Random


class MainActivity : AppCompatActivity(),StoryAdapter.OnStoryClickListener {
    private val NAMES = arrayOf(
        "Alice",
        "Bob",
        "Charlie",
        "David",
        "Emily",
        "Frank",
        "Grace",
        "Henry",
        "Isabella",
        "John",
        "Liam",
        "Nora",
        "Oliver",
        "Penny",
        "Quinn",
        "Thomas",
        "Victoria",
        "William",
        "Yara",
        "Zoe"
    )
    private val POSTS = arrayOf(
        "Just had the best meal of my life!",
        "Can't believe it's already Friday!",
        "So proud of my team for winning the championship!",
        "New haircut, new me!",
        "Feeling grateful for all the love and support in my life!",
        "Excited to announce my new job!",
        "Just finished a great book, highly recommend!",
        "Can't wait to travel again!",
        "Life is too short to not chase your dreams!",
        "So happy to be surrounded by such amazing people!"
    )
    private lateinit var storiesRecyclerView: RecyclerView
    private lateinit var stories: ArrayList<StoryData>
    private lateinit var storiesAdapter: StoryAdapter

    private lateinit var postsRecyclerView: RecyclerView
    private lateinit var posts: ArrayList<PostData>
    private lateinit var postsAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storiesRecyclerView = findViewById(R.id.stories_recycler_view)
        stories = ArrayList()
        createDummyStories()
        storiesAdapter = StoryAdapter(stories,this)
        storiesRecyclerView.adapter = storiesAdapter



        postsRecyclerView = findViewById(R.id.posts_recycler_view)
        posts = ArrayList()
        createDummyPosts()
        postsAdapter = PostAdapter(posts)
        postsRecyclerView.adapter = postsAdapter
    }

    private fun createDummyStories() {
        for (i in 0..5) {
            val color = getRandomColor()
            val darkerColor = darkenColor(color)
            stories.add(
                StoryData(
                    color,
                    darkerColor,
                    getRandomName()
                )
            )
        }
    }

    private fun createDummyPosts() {
        for (i in 0..9) {
            posts.add(
                PostData(
                    getRandomColor(),
                    getRandomName(), getRandomNumber(12).toString() + " hrs .",
                    getRandomPost(), getRandomNumber(500), getRandomNumber(300)
                )
            )
        }
    }

    private fun getRandomColor(): String {
        val random = Random()
        val color = Color.argb(56, random.nextInt(156), random.nextInt(256), random.nextInt(256))
        return String.format("#%06X", 0xFFFFFF and color)
    }

    private fun darkenColor(hexCode:String):String{
        val color = Color.parseColor(hexCode)
        val hsv = FloatArray(3)
        Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), hsv)
        hsv[2] *= 1 - 0.2f
        val rgb = Color.HSVToColor(hsv)
        return String.format("#%06X", 0xFFFFFF and rgb)
    }

    private fun getRandomName(): String {
        val random = Random()
        val index: Int = random.nextInt(NAMES.size)
        return NAMES[index]
    }

    private fun getRandomPost(): String {
        val random = Random()
        val index: Int = random.nextInt(POSTS.size)
        return POSTS[index]
    }

    private fun getRandomNumber(max: Int): Int {
        val random = Random()
        return random.nextInt(max) + 1
    }

    override fun onStoryClick(story: StoryData, position: Int) {
        Toast.makeText(this,"${position+1} - ${story.author}'s story",Toast.LENGTH_LONG).show()
    }
}