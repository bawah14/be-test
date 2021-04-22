file=$1
declare -A full
declare -A time
declare -A result
i=1
counter=0
q1=${2^^}
q2=${3^^}
while read line ; do
	#statements
	full[$i]=$line
	text=$line
	preformatted=${line^^}
	IFS=''
	read -d 'order' -a date <<< "$text"
	if [[ "$preformatted" == *"$q2"* ]] && [[ "$preformatted" == *"$q1"* ]] && [[ "$preformatted" == *"FALSE"* ]]; then
		let counter++
		result[$counter]=$line
	fi
	let i++
done < orderLists.txt
b=($(for l in ${result[@]}; do echo $l; done | sort))
echo $b
if [[ $counter == 0 ]]; then
	#statements
	echo We do not have that on the menu
fi