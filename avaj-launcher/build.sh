find . -name "*.java" > sources.txt
javac --release 7 -sourcepath . @sources.txt
java -cp ./src za.co.julianwolf.Main scenario.txt
