package com.example.foodiepal_culinarycompanion

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.adapter.BlogAdapter
import com.example.foodiepal_culinarycompanion.databinding.FragmentBlogBinding
import com.example.foodiepal_culinarycompanion.model.Blog
import java.time.LocalDate


class BlogFragment : Fragment() {
    private lateinit var blogs: MutableList<Blog>
    private lateinit var binding: FragmentBlogBinding
    private lateinit var blogAdapter: BlogAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            blogs = mutableListOf(
                Blog(
                    "The Art of Mobile App Design",
                    LocalDate.parse("2023-01-01"),
                    "Designing mobile apps requires a combination of creativity and usability. Explore the principles and best practices for creating visually appealing and user-friendly mobile app interfaces.",
                    "Alice Designer",
                    mutableListOf("Amazing insights!", "Looking forward to UI/UX tips.")
                ),
                Blog(
                    "Demystifying Blockchain Technology",
                    LocalDate.parse("2023-02-15"),
                    "Blockchain is more than just cryptocurrency. This blog post delves into the fundamentals of blockchain technology, its applications, and the underlying principles that make it secure.",
                    "Bob Blockchain",
                    mutableListOf("Very informative!", "Blockchain made simple.")
                ),
                Blog(
                    "Advanced Python Tricks and Techniques",
                    LocalDate.parse("2023-03-10"),
                    "Python offers a variety of features and syntax that can enhance your code. Learn advanced Python tricks and techniques to write more concise, readable, and efficient code.",
                    "Charlie Pythonista",
                    mutableListOf("Great Python tips!", "I didn't know about some of these features.")
                ),
                Blog(
                    "Deep Dive into Cloud Computing",
                    LocalDate.parse("2023-04-05"),
                    "Cloud computing is transforming the way we build and deploy applications. This blog provides an in-depth exploration of cloud computing services, architectures, and best practices.",
                    "David Cloud",
                    mutableListOf("Very comprehensive guide!", "Cloud concepts explained well.")
                ),
                Blog(
                    "The Future of Artificial Intelligence",
                    LocalDate.parse("2023-05-20"),
                    "Artificial Intelligence (AI) is rapidly evolving. Explore the current state of AI, its applications across industries, and what the future holds for artificial intelligence.",
                    "Eva AI",
                    mutableListOf("Fascinating read!", "Excited about the future of AI.")
                ),
                Blog("Exploring Kotlin DSLs", LocalDate.parse("2023-01-01"), "Kotlin DSLs (Domain-Specific Languages) can significantly improve code readability and maintainability. Learn the basics of creating and using Kotlin DSLs in this introductory post.", "Alice Developer", mutableListOf("Great introduction!", "Looking forward to more DSL examples.")),
                Blog("Mastering Reactive Programming with RxJava", LocalDate.parse("2023-02-15"), "RxJava is a powerful library for composing asynchronous and event-based programs. Explore the fundamentals and advanced techniques of reactive programming with RxJava.", "Bob Reactive", mutableListOf("This is exactly what I needed!", "RxJava made easy.")),
                Blog("Building Scalable Microservices with Spring Boot", LocalDate.parse("2023-03-10"), "Spring Boot is a popular framework for building microservices. This blog post covers best practices and patterns for designing and implementing scalable microservices using Spring Boot.", "Charlie Microservices", mutableListOf("Excellent guide!", "I appreciate the architecture patterns.")),
                Blog("Exploring Machine Learning Algorithms", LocalDate.parse("2023-04-05"), "Machine learning is a vast field with various algorithms. This blog provides an overview of popular machine learning algorithms and their use cases.", "David Data", mutableListOf("Informative read!", "Would love to see practical examples.")),
                Blog("Modern JavaScript: ES6 and Beyond", LocalDate.parse("2023-05-20"), "ECMAScript 6 (ES6) introduced many new features to JavaScript. Dive into the world of modern JavaScript and discover how ES6 and later versions enhance developer productivity.", "Eva JavaScript", mutableListOf("A must-read for JS developers!", "ES6 features explained well.")),
                Blog("Getting Started with Kotlin DSLs", LocalDate.parse("2023-06-10"), "Learn how to create and use Kotlin DSLs for building expressive and concise APIs. Kotlin's flexibility allows you to design DSLs that suit your specific needs.", "Frank Kotlin", mutableListOf("Fantastic post!", "Kotlin DSLs are a game-changer.")),
                Blog("The Power of GraphQL in Modern Web Development", LocalDate.parse("2023-07-15"), "GraphQL has gained popularity as a query language for APIs. This blog explores the advantages of using GraphQL and how it improves data fetching in web development.", "Grace GraphQL", mutableListOf("Well-explained!", "GraphQL makes API development smoother.")),
                Blog("Understanding Docker Containers", LocalDate.parse("2023-08-05"), "Docker containers have revolutionized application deployment. Dive into the world of containerization, understand the benefits of Docker, and learn how to use containers in your projects.", "Henry Docker", mutableListOf("Great tutorial!", "Docker simplified.")),
                Blog("Building Responsive UIs with Flutter", LocalDate.parse("2023-09-12"), "Flutter is a cross-platform framework for building beautiful and responsive UIs. This blog post guides you through the process of creating responsive user interfaces with Flutter.", "Ivy Flutter", mutableListOf("Flutter is amazing!", "Responsive design made easy.")),
                Blog("Introduction to Neural Networks", LocalDate.parse("2023-10-18"), "Neural networks are the building blocks of deep learning. In this blog, we provide an introduction to neural networks, their architecture, and their applications in machine learning.", "Jack Neural", mutableListOf("Informative content!", "Excited to learn more about deep learning.")),
                Blog("Securing Web Applications: Best Practices", LocalDate.parse("2023-11-25"), "Web application security is crucial in today's digital landscape. Learn the best practices for securing your web applications and protecting them from common vulnerabilities.", "Karen Security", mutableListOf("A must-read for developers!", "Security is paramount.")),
                Blog("Swift Programming for iOS Development", LocalDate.parse("2023-12-03"), "Swift is the programming language for iOS app development. Explore the syntax, features, and best practices of Swift programming to build robust and efficient iOS applications.", "Leo Swift", mutableListOf("Great guide!", "Swift development simplified.")),
                Blog("The Evolution of Frontend Frameworks", LocalDate.parse("2024-01-08"), "Frontend frameworks play a crucial role in modern web development. This blog traces the evolution of popular frontend frameworks and explores their key features.", "Mia Frontend", mutableListOf("Interesting read!", "Frontend frameworks demystified.")),
                Blog("Data Visualization with D3.js", LocalDate.parse("2024-02-14"), "D3.js is a powerful JavaScript library for creating interactive and dynamic data visualizations. Learn the fundamentals of D3.js and how to leverage it for compelling data presentations.", "Nick D3", mutableListOf("Awesome content!", "D3.js opens up endless possibilities.")),
            )
        }
        binding = FragmentBlogBinding.inflate(layoutInflater)
        blogAdapter = BlogAdapter(blogs)
        binding.blogRv.adapter = blogAdapter
        binding.blogRv.layoutManager = LinearLayoutManager(context)

        binding.fab.setOnClickListener {
            var intent = Intent(context, AddBlog::class.java)
            resultContract.launch(intent)
        }

        return binding.root
    }

    private var resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val blog = it.data?.getSerializableExtra("blog") as Blog
            blogs.add(blog)
            blogAdapter.notifyItemInserted(blogs.size - 1)
            Toast.makeText(context, blog.toString(), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "No Blog data given", Toast.LENGTH_SHORT).show()
        }
    }

}