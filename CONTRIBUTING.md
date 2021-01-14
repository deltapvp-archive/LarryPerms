### :speech_balloon: Looking for support?

Good luck finding any, but if you get lucky (cough cough) you might find some [here](https://discord.gg/Dx6SSkx)

### :bug: Reporting bugs?

Please don't.

### :pencil: Want to contribute code?
#### Pull Requests

Just do whatever. You'll get accepted.

#### Project Layout
The project is split up into a few separate modules.

* **API** - The public, semantically versioned API used by other plugins wishing to integrate with and retrieve data from LuckPerms. This module (for the most part) does not contain any implementation itself, and is provided by the plugin.
* **Common** - The common module contains most of the code which implements the respective LuckPerms plugins. This abstract module reduces duplicated code throughout the project.
* **Bukkit** - Uses the common module to implement plugins on the respective server platform.
