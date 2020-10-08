CONFIG_DIR="/home/sami/Desktop/ivr_projects/socialive_ivr_agi_demo_oct2020/working/conf/"
CONFIG_FILE="settings.xml"

SRC_DIR="/etc/asterisk/"
FILE="extensions.conf"

EXTENSION_DIR_PATH="\/home\/sami\/Desktop\/ivr_projects\/socialive_ivr_agi_demo_oct2020\/working\/conf\/dialplan\/"

MAIN_DIALPLAN_CONTEXT=$(awk -F'[<>]' '/<context>/{print $3}' "$CONFIG_DIR/$CONFIG_FILE")
MAIN_EXTENSION_FILE_TO_INCLUDE=$(awk -F'[<>]' '/<extensionsfile>/{print $3}' "$CONFIG_DIR/$CONFIG_FILE")
CONFIG_EXTENSION_FILE_TO_INCLUDE=$(awk -F'[<>]' '/<configfile>/{print $3}' "$CONFIG_DIR/$CONFIG_FILE")
MAIN_EXTENSION=$(grep -Po "(?<=<mainextension>)[^<]*(?=</mainextension>)" "$CONFIG_DIR/$CONFIG_FILE")

#################################################################################################
#CHECK AND append phones context at the last line in extensions.conf taken from settings.xml file
#################################################################################################

#to check if context phones i.e. [phones] is present in the extensions.conf file or not
if ! grep -q "$MAIN_DIALPLAN_CONTEXT" "$SRC_DIR/$FILE";
then
    # if context ([phones]) not found then append it at the end of the file
    printf "\n[$MAIN_DIALPLAN_CONTEXT]\n" >> "$SRC_DIR/$FILE"
fi
#############################################################################################
#CHECK AND include the main extensions file name in extensions.conf taken from settings.xml file
#############################################################################################

#to check if current project's extensions.conf file is already present in main asterisk extensions.conf file or not 
if ! grep -q '#include '"$EXTENSION_DIR_PATH""$MAIN_EXTENSION_FILE_TO_INCLUDE" "$SRC_DIR/$FILE";
then
    #not found
    sed -i '1s/^/#include '"$EXTENSION_DIR_PATH""$MAIN_EXTENSION_FILE_TO_INCLUDE"'\n/' "$SRC_DIR/$FILE"
fi
#############################################################################################
#CHECK AND include the configuration file name in extensions.conf taken from settings.xml file
#############################################################################################

#to check if current project's configuration file is already present in main asterisk extensions.conf file or not 
if ! grep -q '#include '"$EXTENSION_DIR_PATH""$CONFIG_EXTENSION_FILE_TO_INCLUDE" "$SRC_DIR/$FILE";
then
    #not found
    sed -i '1s/^/#include '"$EXTENSION_DIR_PATH""$CONFIG_EXTENSION_FILE_TO_INCLUDE"'\n/' "$SRC_DIR/$FILE"
fi
######################################################################################################
#CHECK AND include the main extension of the service in extensions.conf taken from settings.xml file
######################################################################################################
if ! grep -q "$MAIN_EXTENSION" "$SRC_DIR/$FILE";
then
    #not found
    sed -i '/\['"$MAIN_DIALPLAN_CONTEXT"'\]/a '"$MAIN_EXTENSION" "$SRC_DIR/$FILE"
fi
######################################################################################################
