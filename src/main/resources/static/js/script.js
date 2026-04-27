//console.log("script");

let currentTheme=getTheme();

changeTheme();

function changeTheme(){
document.querySelector('html').classList.add(currentTheme);
	let changeThemeButton =document.querySelector('#theme_change_button');
	
	changeThemeButton.querySelector('span').textContent=currentTheme=='light' ? 'dark': 'light';
	
		changeThemeButton.addEventListener("click",(event) => {
			
			let oldtheme=currentTheme;
			console.log("Change button theme");
			
			
			if(currentTheme==='dark'){
				currentTheme="light";
			}else{
			currentTheme="dark";
			}
			
			setTheme(currentTheme);
			
			
		document.querySelector('html').classList.remove(oldtheme);
			
			document.querySelector('html').classList.add(currentTheme);
			
			
			
		});
	
	
}


function setTheme(theme){
	localStorage.setItem("theme",theme);
	
}


function getTheme(){
	let theme=localStorage.getItem("theme");
	if(theme)
		return theme ? theme:"light"
}