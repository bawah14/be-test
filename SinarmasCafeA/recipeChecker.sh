#!/bin/bash
file=$1
echo $file
declare -A stock
while read line ; do
	#statements
	# echo ${line^^}
	txt=${line^^}
	if [[ -v "stock[$txt]" ]] ; then
		((stock["$txt"]++))
	else
		let stock["$txt"]=1
	fi
	# echo "jumlah $txt = ${stock[$txt]}" 
done < fruitList.txt
# echo ${stock[*]}
menu=${2^^}
case $menu in

  "APPLE PIE")
    if [[ ${stock["APPLE,"]} -ge 2 ]]; then
    	echo "You shall have APPLE PIE!"	
    else
    	echo "You shall not have APPLE PIE!"		
    fi
    ;;

  "PINEAPPLE PIE")
    if [[ ${stock["PINEAPPLE,"]} -ge 3 ]]; then
    	echo "You shall have PINEAPPLE PIE!"	
    	
    else
    	echo "You shall not have PINEAPPLE PIE!"	

    fi
    ;;

  "FRUIT PARFAIT")
    if [[ ${stock["PINEAPPLE,"]} -ge 2 ]] && [[ ${stock["APPLE,"]} -ge 2 ]] ; then
    	echo "You shall have FRUIT PARFAIT!"	
    	
    else
    	echo "You shall not have FRUIT PARFAIT!"	

    fi
    ;;

  *)
    echo "We do not have that on the menu"
    ;;
esac