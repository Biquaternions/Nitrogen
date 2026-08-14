<div align="center">

## ⚛️ Nitrogen ⚛️
Nitrogen is a [Paper](https://github.com/PaperMC/Paper)/[Pufferfish](https://github.com/pufferfish-gg/Pufferfish/) fork designed to restore legacy 1.8 combat.


</div>

> [!WARNING]
> This project is in its early stages and I do not recommend using it. \
> At the time of writing this, it DOES NOT match a 1.8 combat behavior 1:1. 
>

> [!CAUTION]
> This project breaks plugin expectations about the software it will be running on. \
> Any plugin that expects modern combat mechanics is considered incompatible. \
> Any plugin that attempts to restore 1.8 behavior is also considered fundamentally incompatible,
> as it does the exact same thing this project attempts to achieve. 
>

## Design
Given Minecraft is headed to be fully data-driven and is already very customizable, anything that can be achieved via
data components, will only have the default values changed to match legacy combat.

Anything that cannot be achieved with components, will instead have its own dedicated patch, trying to keep plugin compatibility
whenever possible.

This project can be considered a pseudo-fork of [PandaSpigot](https://github.com/hpfxd/pandaspigot). Nitrogen doesn't take patches
directly from PandaSpigot, but I use their setup to have access to 1.8 source code.

## Limitations
Legacy combat will not be toggleable for the foreseeable future. This means all players will experience legacy combat
when playing in servers running Nitrogen with no way to use modern combat.

This also means that plugin compatibility is limited in terms of combat mechanics, as it breaks expectations over how often can
players attack, how the default knockback is going to be, etc. \
I also expect plugins that attempt to mimic legacy combat, such as OldCombatMechanics, will be fundamentally incompatible
with Nitrogen, as both do the same thing.

## License
All patches are licensed under the MIT license.

See [PaperMC/Paper](https://github.com/PaperMC/Paper), and [PaperMC/Paperweight](https://github.com/PaperMC/paperweight) for the license of material used by this project.

## Building and setting up

#### Initial setup
First, <u>clone</u> this repository. Do not download it.

Then run the following command in the root directory:

```
./gradlew applyAllPatches
```

The project is now ready for use in your IDE.

#### Creating a patch

See [CONTRIBUTING.md](CONTRIBUTING.md).

#### Compiling

Use the command `./gradlew build` to build the API and server. Compiled JARs
will be placed under `nitrogen-api/build/libs` and `nitrogen-server/build/libs`.
**These JARs are not used to start a server.**

To compile a server-ready paperclip jar, run `./gradlew createBundlerJar`.
To install the `nitrogen-api` and `nitrogen` dependencies to your local Maven repo, run `./gradlew publishToMavenLocal`. The compiled paperclip jar will be in `nitrogen-server/build/libs`.

# Credits:

1. PaperMC Team.
2. Pufferfish Host.
3. PandaSpigot Team.
4. Winds-Studio, for their auto release script.
