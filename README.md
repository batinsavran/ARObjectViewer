# ARObjectViewer

ARObjectViewer is an Android application that utilizes Augmented Reality (AR) technology to display 3D models in the real world. When the app is launched, it activates the camera, and once a surface is detected, a predefined 3D model is rendered in the augmented environment.

## Features

- **Camera Integration:** The app starts with the camera view.
- **Surface Detection:** Automatically detects surfaces for model placement.
- **3D Model Rendering:** Displays a defined 3D model when a surface is detected.

## Technologies Used

- Android SDK
- ARCore
- OpenGL ES (for 3D rendering)

### Prerequisites

- Android Studio
- Android device with ARCore support
- Basic knowledge of Kotlin and Android development

### Installation

1. Clone the repository:
   ```bash
    git clone https://github.com/yourusername/ARObjectViewer.git
   ```
2. Open the project in Android Studio.
3. Ensure you have the necessary permissions for camera access in your AndroidManifest.xml file.
4. Connect your ARCore-compatible device and run the application.

## Usage

1. Launch the app on your ARCore-compatible Android device.
2. Point the camera at a flat surface.
3. Once the surface is detected, the 3D model will appear in the camera view.

## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, please open an issue or submit a pull request.

## Acknowledgments

- Thanks to the ARCore team for providing the tools and resources for building AR applications.
- Inspired by various AR projects and tutorials available online.
