<h1 align="center">Command-Line RPG Game</h1>

<p align="center">
    Welcome to the <b>Command-Line RPG Game</b>, a text-based adventure that brings the excitement of role-playing games (RPGs) to your terminal! This game combines exploration, combat, and character progression in a classic turn-based format. Build your character, battle monsters, and collect treasures as you journey through a dynamic and immersive world—all from the comfort of your command line.
</p>

---

<h2>Features</h2>

<h3>🎮 Core Gameplay</h3>
<ul>
    <li><b>Turn-Based Combat</b>: Engage in battles against randomly generated monsters with unique stats and abilities.</li>
    <li><b>Character Progression</b>: Level up your character by gaining experience points (XP), improving attributes such as health, attack, and defense.</li>
    <li><b>Healing System</b>: Strategically use healing during battles to ensure survival.</li>
</ul>

<h3>💼 Inventory System</h3>
<ul>
    <li>Collect items like weapons, potions, and shields while exploring.</li>
    <li>View and manage your inventory easily through the user interface.</li>
    <li>Avoid duplicates with intelligent item tracking.</li>
</ul>

<h3>💾 Save and Load Functionality</h3>
<ul>
    <li>Save your progress at any point using customizable filenames.</li>
    <li>Load saved games to continue your adventure from where you left off.</li>
    <li>Game states are stored in a user-friendly <b>JSON format</b>, making them easy to debug or extend.</li>
</ul>

<h3>🌍 Exploration</h3>
<ul>
    <li>Venture into the wilderness to encounter monsters or discover treasures.</li>
    <li>Random events keep the gameplay dynamic and engaging.</li>
</ul>
---

<h2>Getting Started</h2>

<h3>Prerequisites</h3>
<p>To run the game, ensure you have the following installed:</p>
<ul>
    <li>Java Development Kit (JDK) 8 or higher</li>
    <li>Gson library for JSON handling (already included in dependencies if using Maven)</li>
</ul>

<h3>Installation</h3>
<ol>
    <li>Clone this repository:
        <pre><code>git clone https://github.com/michaelarayabe/rpgConsole.git</code></pre>
    </li>
    <li>Navigate to the project directory:
        <pre><code>cd rpgConsole</code></pre>
    </li>
    <li>Compile the game:
        <pre><code>javac -cp gson-2.10.0.jar src/*.java -d out</code></pre>
    </li>
    <li>Run the game:
        <pre><code>java -cp gson-2.10.0.jar:out GameEngine</code></pre>
    </li>
</ol>

---

<h2>How to Play</h2>

<ol>
    <li><b>Start a New Game</b>: Enter your character's name to begin your journey.</li>
    <li><b>Explore</b>: Choose to explore the wilderness, where you can battle monsters or find treasures.</li>
    <li><b>Fight or Heal</b>: During battles, choose between attacking the monster or healing yourself.</li>
    <li><b>Manage Inventory</b>: View and manage collected items like potions, weapons, and shields.</li>
    <li><b>Save Progress</b>: Save your game at any point by entering a custom filename.</li>
    <li><b>Load Progress</b>: Load a saved game to pick up right where you left off.</li>
</ol>

---

<h2>Example Interaction</h2>

<pre><code>
Welcome to the Command-Line RPG!
Enter your character's name: Hero

Choose an action:
1. Explore
2. Check Stats
3. View Inventory
4. Quit
> 1

You venture into the wilderness...
You found a Potion!
Potion added to inventory!

Choose an action:
1. Explore
2. Check Stats
3. View Inventory
4. Quit
> 3

Inventory:
1. Potion
</code></pre>

---

<h2>Contributing</h2>

<p>Contributions are welcome! Feel free to fork the repository and submit pull requests with your enhancements or bug fixes.</p>

---

<h2>License</h2>

<p>This project is licensed under the MIT License.</p>
