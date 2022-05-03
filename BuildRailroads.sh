CLASS_PATH="out/src"
SOURCES=$(find -path "./src/*" -name "*.java")

mkdir -p $CLASS_PATH

javac -d $CLASS_PATH -cp $CLASS_PATH ${SOURCES}

echo Application build into $CLASS_PATH
