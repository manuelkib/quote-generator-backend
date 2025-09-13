package com.inspireflow.quotegenerator.service;

import com.inspireflow.quotegenerator.model.Quote;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class QuoteService {

    private final String EXTERNAL_API_URL = "https://api.quotable.io/random";
    private final RestTemplate restTemplate = new RestTemplate();

    // Demo quotes for fallback
    // Demo quotes for fallback - Expanded collection
private final Quote[] demoQuotes = {
    // Motivational Quotes
    new Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
    new Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"),
    new Quote("Your time is limited, so don't waste it living someone else's life.", "Steve Jobs"),
    new Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"),
    new Quote("Strive not to be a success, but rather to be of value.", "Albert Einstein"),
    new Quote("I have not failed. I've just found 10,000 ways that won't work.", "Thomas Edison"),
    
    // Wisdom & Life Quotes
    new Quote("In the middle of difficulty lies opportunity.", "Albert Einstein"),
    new Quote("Life is what happens when you're busy making other plans.", "John Lennon"),
    new Quote("The only impossible journey is the one you never begin.", "Tony Robbins"),
    new Quote("The purpose of our lives is to be happy.", "Dalai Lama"),
    new Quote("Get busy living or get busy dying.", "Stephen King"),
    new Quote("You only live once, but if you do it right, once is enough.", "Mae West"),
    
    // Success & Achievement
    new Quote("Success is not final, failure is not fatal: it is the courage to continue that counts.", "Winston Churchill"),
    new Quote("The way to get started is to quit talking and begin doing.", "Walt Disney"),
    new Quote("Don't let yesterday take up too much of today.", "Will Rogers"),
    new Quote("Opportunities don't happen. You create them.", "Chris Grosser"),
    new Quote("The harder I work, the more luck I seem to have.", "Thomas Jefferson"),
    
    // Technology & Innovation
    new Quote("The computer was born to solve problems that did not exist before.", "Bill Gates"),
    new Quote("The best way to predict the future is to invent it.", "Alan Kay"),
    new Quote("Technology is nothing. What's important is that you have faith in people.", "Steve Jobs"),
    new Quote("The Internet is becoming the town square for the global village of tomorrow.", "Bill Gates"),
    new Quote("Software is a great combination between artistry and engineering.", "Bill Gates"),
    
    // African Wisdom
    new Quote("Until the lion learns how to write, every story will glorify the hunter.", "African Proverb"),
    new Quote("If you want to go quickly, go alone. If you want to go far, go together.", "African Proverb"),
    new Quote("A child who is not embraced by the village will burn it down to feel its warmth.", "African Proverb"),
    new Quote("The axe forgets; the tree remembers.", "African Proverb"),
    new Quote("Smooth seas do not make skillful sailors.", "African Proverb"),
    
    // Programming & Development
    new Quote("The best thing about a boolean is even if you are wrong, you are only off by a bit.", "Anonymous"),
    new Quote("There are two ways to write error-free programs; only the third works.", "Alan Perlis"),
    new Quote("First, solve the problem. Then, write the code.", "John Johnson"),
    new Quote("Code is like humor. When you have to explain it, it's bad.", "Cory House"),
    new Quote("Make it work, make it right, make it fast.", "Kent Beck"),
    
    // Tanzanian Inspiration
    new Quote("Education is the great engine of personal development.", "Nelson Mandela"),
    new Quote("It always seems impossible until it's done.", "Nelson Mandela"),
    new Quote("Africa's story has been written by others; we need to own our problems.", "Paul Kagame"),
    new Quote("The power of education extends beyond the development of skills we need for economic success.", "Nelson Mandela"),
    new Quote("Development is about transforming the lives of people, not just transforming economies.", "Julius Nyerere"),
    
    // Personal Growth
    new Quote("Be yourself; everyone else is already taken.", "Oscar Wilde"),
    new Quote("Act as if what you do makes a difference. It does.", "William James"),
    new Quote("The only person you are destined to become is the person you decide to be.", "Ralph Waldo Emerson"),
    new Quote("When we give cheerfully and accept gratefully, everyone is blessed.", "Maya Angelou"),
    new Quote("Life isn't about finding yourself. Life is about creating yourself.", "George Bernard Shaw"),
    
    // Funny & Lighthearted
    new Quote("I'm not lazy, I'm just on energy-saving mode.", "Anonymous"),
    new Quote("Code never lies, comments sometimes do.", "Ron Jeffries"),
    new Quote("There are only 10 types of people in the world: those who understand binary and those who don't.", "Anonymous"),
    new Quote("I would love to change the world, but they won't give me the source code.", "Anonymous"),
    new Quote("Programming is like sex: One mistake and you have to support it for the rest of your life.", "Michael Sinz"),
    
    // Additional Wisdom
    new Quote("The greatest glory in living lies not in never falling, but in rising every time we fall.", "Nelson Mandela"),
    new Quote("The way to get started is to quit talking and begin doing.", "Walt Disney"),
    new Quote("If life were predictable it would cease to be life, and be without flavor.", "Eleanor Roosevelt"),
    new Quote("If you look at what you have in life, you'll always have more.", "Oprah Winfrey"),
    new Quote("If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.", "James Cameron")
};

    public Quote getRandomQuote() {
        try {
            // Try to get quote from external API
            QuoteResponse response = restTemplate.getForObject(EXTERNAL_API_URL, QuoteResponse.class);
            
            if (response != null && response.getContent() != null && response.getAuthor() != null) {
                return new Quote(response.getContent(), response.getAuthor());
            }
            
        } catch (HttpClientErrorException e) {
            System.out.println("API Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        
        // Fallback to demo quotes if external API fails
        return getDemoQuote();
    }

    public Quote getDemoQuote() {
        int randomIndex = (int) (Math.random() * demoQuotes.length);
        return demoQuotes[randomIndex];
    }

    // Helper class to map the external API response
    private static class QuoteResponse {
        private String content;
        private String author;

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
    }
}