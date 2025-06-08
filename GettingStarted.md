
# <font  color="#FFC19C"> Getting Started With Java: </font>

## Installing Java:

  

- In order to even be able to mod Minecraft Java Edition, I needed to install Java on my computer.<br>

- There are many ways to do this, with many different versions of Java.<br>

<br>

  

- I followed [this guide](https://www.mcjty.eu/docs/1.20/) by McJty, who does a great service with Minecraft modding tutorials.<br>

- I clicked on download Java 17 for Minecraft 1.20. Next, I went to VSCode (my preferred IDE), and installed some Java extensions.<br>

<br>

  

- <em>Normally, this is where the installation journey ends for most people. I was not like most people.<br>

- My VSCode did not recognize that I had Java installed (evident due to the big fat error saying command "javac" not found).<br>

- So I did some research into this issue for VSCode on Windows and managed to fix if after some key discoveries:</em><br>

<br>

> - <strong>One: Do not install any Java extensions until after you've installed the language. VSCode automatically searches for your JDK path,</strong>
> <br>

> - <strong>so if you do not have it installed, there won't be anything for it to use. To fix this, you can try re-installing your extensions.<br><br><br></strong>

> - <strong>Two: If you still have issues, you can go to your environment settings and change your path for JDK. VSCode doesn't like it when you include the bin directory in your path.</strong>
> <br>
> - <strong>So, go one level up, save your changes, and when VSCode goes to look for Java on your computer, it will be findable<br></strong>

I added this in VI trough my MobaXterm WSL terminal. Hopefully it saves. Soon I will learn git terminal commands!
