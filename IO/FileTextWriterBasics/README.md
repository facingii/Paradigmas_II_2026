# FileTextWriterBasics

Small Java IO examples for teaching how to create CSV files with `OutputStream`.

## Included examples

The project generates the same synthetic student data with four approaches:

1. `FileOutputStream` writing the complete CSV as UTF-8 bytes.
2. `BufferedOutputStream` writing one line at a time.
3. `Files.newOutputStream` combined with `OutputStreamWriter`.
4. `PrintStream` formatting text on top of an `OutputStream`.

The synthetic data intentionally includes values with commas and quotes so students can see why CSV escaping matters.

## Compile and run

```powershell
Set-Location "C:\paradigmas\Paradigmas_II_2026\IO\FileTextWriterBasics"
New-Item -ItemType Directory -Force -Path out | Out-Null
javac -d out (Get-ChildItem -Path src\main\java -Recurse -Filter *.java | ForEach-Object FullName)
java -cp out mx.uv.fiee.iinf.paradigmas.io.Main
```

## Run the verification harness

```powershell
Set-Location "C:\paradigmas\Paradigmas_II_2026\IO\FileTextWriterBasics"
New-Item -ItemType Directory -Force -Path out-test | Out-Null
javac -d out-test (Get-ChildItem -Path src\main\java -Recurse -Filter *.java | ForEach-Object FullName) (Get-ChildItem -Path src\test\java -Recurse -Filter *.java | ForEach-Object FullName)
java -cp out-test mx.uv.fiee.iinf.paradigmas.io.CsvExamplesVerification
```

Generated files are written to `generated-csv/` from the working directory.

