# Use this code to choose what to do (this is better for less stress than coding all)
import random

languages = ["Python", "Kotlin", "SQL", "Pandas+NumPy+Matplotlib", "PHP+HTML"]
makers = ["ChatGPT", "Gemini", "Perplexity", "DeepSeek", "Grok"]

language = [random.choice(languages) for i in range(2)]
maker = random.choice(makers)
question = random.randint(1, 2)

print(f"Code in: {" and ".join(language)}")
print(f"Prompts from: {maker}")
print(f"Generate: {question} prompts")
print(f"Finish in a week (7 days)")
