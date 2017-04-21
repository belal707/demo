node 
{
  	checkout scm
  	stage('Package') 
  	{
     	sh 'mvn clean package -DskipTests'
  	}
  	
  	stage('Create Docker Image') 
	{
			docker.build("belalansari/demo:latest")
  	}
  	stage('Run Tests and Deploy') 
	{
		try 
		{  
		    sh "mvn test"
			sh "docker login -u belalansari -p zamila1234 -e belalansari087@gmail.com"
		    docker.build("belalansari/demo:latest").push()
			
		} catch (error)
		{
			println("Error:" + error)
		} 
	}
}  	