#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <float.h>
#include <math.h>
#include <iostream>
#include <glut.h>

using namespace std;
int aciX, aciY, aciZ = 0;
float Don;

static GLuint texture[6];
GLuint LoadTextureRAW(const char * filename)
{
	GLuint texture;

	unsigned char* data;
	FILE * file;

	file = fopen(filename, "rb");
	if (file == NULL)
		return 0;
	
	float width = 512;
	float height = 512;
	data = (unsigned char*)malloc(width * height * 3);

	fread(data, width * height * 3, 1, file);
	fclose(file);
	glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

	glGenTextures(1, &texture);
	glBindTexture(GL_TEXTURE_2D, texture);
	
	glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
	
	glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR_MIPMAP_NEAREST);
	glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

	glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
	glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
	glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE, data);    

	
	free(data);
	return texture;
}

void thiswillDrawCube(){
	glEnable(GL_TEXTURE_2D);
	glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_DECAL);
	float x0 = -1.0, y0 = -1, x1 = 1, y1 = 1, z0 = 1;
	float face[6][4][3] = { { { x0, y0, z0 }, { x1, y0, z0 }, { x1, y1, z0 }, { x0, y1, z0 } },  
	{ { x0, y1, -z0 }, { x1, y1, -z0 }, { x1, y0, -z0 }, { x0, y0, -z0 } },   
	{ { x1, y0, z0 }, { x1, y0, -z0 }, { x1, y1, -z0 }, { x1, y1, z0 } },     
	{ { x0, y0, z0 }, { x0, y1, z0 }, { x0, y1, -z0 }, { x0, y0, -z0 } },    
	{ { x0, y1, z0 }, { x1, y1, z0 }, { x1, y1, -z0 }, { x0, y1, -z0 } },     
	{ { x0, y0, z0 }, { x0, y0, -z0 }, { x1, y0, -z0 }, { x1, y0, z0 } }   
	};
	glEnable(GL_CULL_FACE);
	glCullFace(GL_BACK);

	 
	glRotatef(35, 1.0, 0.0, 0.0);
	glRotatef(Don, 1.0, 1.0, 0.0);
	glRotatef(aciX, 1.0, 0.0, 0.0);      
	glRotatef(aciY, 0.0, 1.0, 0.0);       
	glRotatef(aciZ, 0.0, 0.0, 1.0);

	
	glScalef(0.5, 0.5, 0.5);
	for (int i = 0; i < 6; ++i) {      
		glBindTexture(GL_TEXTURE_2D, texture[i]);
		glBegin(GL_QUADS);
		glTexCoord2f(0.0, 0.0); glVertex3fv(face[i][0]);
		glTexCoord2f(1.0, 0.0); glVertex3fv(face[i][1]);
		glTexCoord2f(1.0, 1.0); glVertex3fv(face[i][2]);
		glTexCoord2f(0.0, 1.0); glVertex3fv(face[i][3]);
		glEnd();
	}
	glFlush();
	
	glDisable(GL_TEXTURE_2D);
}

void display(void)
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	glPushMatrix();
	thiswillDrawCube();
	glPopMatrix();
	glutSwapBuffers();
}
void DondDisplay(){
	Don = Don + 5;
	if (Don > 360)
		Don = Don - 360;
	glutPostRedisplay();
}
void keyboard(unsigned char key, int x, int y)
{
	switch (key) {
	case 's':
		aciX = (aciX + 10) % 360;
		break;
	case 'S':
		aciX = (aciX - 10) % 360;
		break;
	case 'a':
		aciY = (aciY + 10) % 360;
		break;
	case 'A':
		aciY = (aciY - 10) % 360;
		break;
	case 'd':
		aciZ = (aciZ + 10) % 360;
		break;
	case 'D':
		aciZ = (aciZ - 10) % 360;
		break;
	case 'r':
		DondDisplay();
		glutPostRedisplay();

	}
	glutPostRedisplay();
}


void init(void)
{
	glClearColor(.0, .0, 0.5, .6);
	glShadeModel(GL_SMOOTH);
	glEnable(GL_DEPTH_TEST);

	texture[0] = LoadTextureRAW("1.bmp");

	texture[1] = LoadTextureRAW("2.bmp");

	texture[2] = LoadTextureRAW("3.bmp");

	texture[3] = LoadTextureRAW("4.bmp");

	texture[4] = LoadTextureRAW("5.bmp");
	texture[5] = LoadTextureRAW("6.bmp");
}
void mouse(int button, int durum, int x, int y)            
{
	switch (button) {
	case GLUT_LEFT_BUTTON:
		if (durum == GLUT_DOWN)
			glutIdleFunc(DondDisplay);

		break;
	case GLUT_RIGHT_BUTTON:
		if (durum == GLUT_DOWN)
		{
			glutIdleFunc(NULL);
		}

		break;
	default:
		break;
	}
}


void reshape(int w, int h)
{
	glViewport(0, 0, (GLsizei)w, (GLsizei)h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(60.0, (GLfloat)w / (GLfloat)h, 1.0, 30.0);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(0,0,5.0,0,0,0,0,50,0);
}
int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(1200,600);
	glutInitWindowPosition(50,50);
	glutCreateWindow("HADÝ KEMÝK");
	init();
	glutDisplayFunc(display);
	glutReshapeFunc(reshape);
	glutKeyboardFunc(keyboard);
	glutMouseFunc(mouse);
	glutMainLoop();
	return 0;
}