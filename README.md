# StaticAnalysis_DigitalWallets

Requirements: 
--------------------------------------------------------------------------------------------------------------------------------------------------------------
1) DARE as tool to convert Android DEX (Dalvik) files to Java Classes.
2) JDK Version 1.6 or 1.7 is required.
3) Virtual Box
4) Ubuntu 12.04
5) JAD Java Decompiler
6) WINE as a compatibility software to run jad.exe in Ubuntu
7) Eclipse
 
--------------------------------------------------------------------------------------------------------------------------------------------------------------

Process:

Step 1: Before running DARE on a 64-Bit System, ia32-libs library , needed to be installed by using the following command:

	sudo apt-get install ia32-libs

Ubuntu version 14.04 was not allowing these files to be installed with error as follows:

Package ia32-libs is not available, but is referred to by another package.
This may mean that the package is missing, has been obsoleted, or
is only available from another source
However the following packages replace it:
	  lib32z1 lib32ncurses5 lib32bz2-1.0

But DARE did not run after installing these files mentioned by the system.

Step 2: Installed Ubuntu 12.04 on a Virtual Machine using Virtual Box.
It allowed installation of ia32-libs library.

Step 3: Running Dare in the terminal using command as follows and before that BootStrap Optimization is required. That can be done using 
./dex-preopt –bootstrap
(have to be in Extracted DARE folder to Run this command)

Step 4: Running DARE to Extract and Decompile DALVIK files to Java Classes.
% dare -d <Mention location of Out .class FIles>   <Mention location of APK file to be Decompiled>

Step 5: Use any JAVA DE-compiler to convert .class into Readable .java files.

Step 6: Java files were scrutinized one by one following tree pattern and mapping. Dexter Labs provided required information on the mapping.
http://dexter.dexlabs.org/ 

Step 7: Java Source Code was checked for following Parameters:
		a) Access of Device ID (IMEI etc.) 
		b) Access of Location
		c) Connection Request
		d) Access to Local IP Addess
		e) Encryption
		f) Obfuscation

--------------------------------------------------------------------------------------------------------------------------------------------------------------


