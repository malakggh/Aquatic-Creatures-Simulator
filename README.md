# Aquatic Creatures Simulator

## Overview

Welcome to the Aquatic Creatures Simulator project! This project, developed as part of the "Object-oriented Programming Advanced" course, is a GUI application simulating an aquarium environment. It involves creating classes representing various sea creatures, implementing advanced object-oriented programming concepts, incorporating GUI functionalities, and focusing on multithreading best practices.

## Multithreading Focus

The primary focus of this project was to implement multithreading concepts effectively, avoiding bad practices such as busy waiting, and ensuring a good way of communicating between threads. The project emphasizes best practices for concurrent programming to enhance the efficiency and reliability of the simulator.

## GUI Application: Aquatic Creatures Simulator

### General Definitions

Six classes define the application's structure:
- `AquaFrame`: Includes the main() function.
- `AquaPanel`: Manages GUI elements and serves as the canvas for drawing aquatic creatures.
- `AddAnimalDialog`: A dialog window for adding new animals.
- `Swimmable` (abstract class): Represents aquatic creatures with common attributes and behaviors.
- `Fish` (extends `Swimmable`): Represents a fish.
- `Jellyfish` (extends `Swimmable`): Represents a jellyfish.

### GUI and Controls Definitions

- **Menu Options:**
  - Exit: Closes the program.
  - Image: Sets an image as the aquarium background.
  - Blue: Sets a blue background for the aquarium.
  - None: Aquarium without a background.
  - Help: Opens a dialog with relevant information.

- **Buttons (AquaPanel):**
  - Add Animal: Opens the `AddAnimalDialog` window to define a new creature.
  - Sleep: Temporarily stops all creatures.
  - Wake up: Resumes swimming for all creatures.
  - Reset: Clears all creatures.
  - Food: Releases food (worm) at the center of `AquaPanel`, causing creatures to swim towards it.
  - Info: Displays information about fish and jellyfish in a `JTable`.
  - Exit: Closes the program.

### Model Definitions

- Each creature is a Thread that starts running immediately.
- All creatures are stored in a `HashSet<Swimmable>` in `AquaPanel`.
- After any change, call the `paintComponent()` function of `AquaPanel` to repaint.
- `Fish` and `Jellyfish` classes define the `drawAnimal()` function, called in `paintComponent()` for all creatures.

### Additional Implementations

- Utilization of `wait()` and `notify()` functions to stop and wake up creatures.
- Implementation of a synchronization mechanism for worm eating using `CyclicBarrier`. A `CyclicBarrier` with the number of creatures is activated when food appears, updating the "Eat counter" for each fish or jellyfish that reaches the worm.

## Design Patterns Implemented

1. **Singleton:**
   - Implemented a `Singleton` class, ensuring a single instance of the worm globally.

2. **Abstract Factory:**
   - Created `AnimalFactory` and `PlantFactory` to create instances of `Fish`, `Jellyfish`, `Laminaria`, and `Zostera`.

3. **Prototype:**
   - Implemented the Prototype pattern by allowing duplication of instances of `Fish` and `Jellyfish` using a "Animal Duplicate" button in `AquaPanel`.

4. **Listener/Observer:**
   - Implemented the Observer pattern, making the Aquarium listen to fish requests for food and updating the user with a pop-up window.

5. **Decorator:**
   - Implemented the Decorator pattern by adding a "Decorator" button to `AquaPanel`, which opens a new panel (`JPanelDecorator`) with options like "Color Change" for each animal.

6. **Memento:**
   - Added a "Memento" menu item to the menu bar with options to save and restore the state of animals on `AquaPanel`.

7. **State:**
   - Implemented the State pattern by introducing states (`Hungry` and `Satiated`) for fish based on feeding conditions, affecting their behavior.

## Commit Messages

Please note that commit messages in this repository may appear random. This is because the repository was initially intended to be private for educational purposes, and commits were made to get the job done rather than following a conventional commit message structure.

## Getting Started

To run the Aquatic Creatures Simulator, execute the `main()` function in `AquaFrame`. Explore the GUI interface, add creatures, and observe their behaviors.

Feel free to contribute, report issues, or suggest improvements. Happy simulating!
