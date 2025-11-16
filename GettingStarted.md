
# <font  color="#FFC19C"> Getting Started With Java: </font>

## Installing Java:

  

- In order to even be able to mod Minecraft Java Edition, I needed to install Java on my computer.<br>

- There are many ways to do this, with many different versions of Java.<br>

<br>

  

- I followed [this guide](https://www.mcjty.eu/docs/1.20/) by McJty, who does a great service with Minecraft modding tutorials.<br>

- I clicked on download Java 17 MSI, as Java 17 is used for the newest builds of Minecraft, such as 1.20.1. Next, I went to VSCode (my preferred IDE), and installed the recommended Java development extention pack. Since I will be working with Gradle to actually run Minecraft when I playtest mods, I need VSCode to be able to communicate with it.<br>

- Secondly, I also downloaded Gradle for forge (linked on the homepage for McJty's tutorial), ensuring to select the zip folder instead of the executable because I needed only to copy a select few files necesary to run Gradle and copy them into my project's directory.<br>

<br>

  

- <em>Normally, this is where the installation journey ends for most people. I was not like most people.<br>

- My VSCode did not recognize that I had Java installed (evident due to the big fat error saying command "javac" not found).<br>

- So I did some research into this issue for VSCOde on Windows and managed to fix it after some key discoveries:<br>

</em><br>

> - <strong>One: Do not install any Java extensions until after you've installed the language. VSCode automatically searches for your JDK path.<br><br>
> If you do not have it installed, there won't be anything for it to use. To fix this, you can try re-installing your extensions.<br><br>

> - Two: If you still have issues, you can go to your environment settings and change your path for JDK. VSCode doesn't like it when you include the bin directory in your path.<br><br>
So, go one level up, save your changes, and when VSCode goes to look for Java on your computer, it will be findable<br><br>

> - Three: VSCode may need a higher version of Java (21+ to be specific) in order to communicate with Gradle, meaning that you may need two different versions of Java. Java 17 for your environment, but Java 21+ for VSCode's workspace JSON settings.</strong>