# PluginStructureExtractor

A simple Java CLI tool to extract the internal structure of a plugin JAR or ZIP file and save it as a fingerprint. Useful for comparing plugin artifacts for similarity.

## Build

```bash
javac PluginStructureExtractor.java
```
## Usage

### Extract structure from a plugin

```bash
java PluginStructureExtractor pluginA.zip pluginA.fingerprint
```
