#export JAVA_HOME=$JRE8_LIB_DIR/../
echo "Using JAVA home: $JAVA_HOME"


rm -rf jar
ant
#read -p "Press any key to continue…" var
