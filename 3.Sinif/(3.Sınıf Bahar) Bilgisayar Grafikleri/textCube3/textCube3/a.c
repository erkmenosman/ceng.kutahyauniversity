#define _CRT_SECURE_NO_WARNINGS
#include <stdlib.h>
//#include <stdio.h>
#include <math.h>
#include <glut.h>
#include "bitmap.c"
//#include <string.h>
BITMAPINFO *TexInfo, *TexInfo2, *TexInfo3, *TexInfo4, *TexInfo5, *TexInfo6; /* Texture bitmap information */
GLubyte *TexBits, *TexBits2, *TexBits3, *TexBits4, *TexBits5, *TexBits6; /* Texture bitmap pixel bits */
static GLuint texName[6];
float xRot = 0, x1rot = 0.05;
float yRot = 0, y1rot = 0.05;
float zRot = 0, z1rot = 0.05;
int dondur = 1;
int bas = 0;
int stop = 0;
GLint spinx = 0;
GLint spiny = 0;
GLubyte *LoadDIBitmap(const char *filename, BITMAPINFO **info);

void init(void){

	glEnable(GL_DEPTH_TEST);
	glShadeModel(GL_SMOOTH);
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glGenTextures(6, texName);

	glBindTexture(GL_TEXTURE_2D, texName[0]);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo->bmiHeader.biWidth, TexInfo->bmiHeader.biHeight, 0, GL_BGR_EXT, GL_UNSIGNED_BYTE, TexBits);
	glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	glBindTexture(GL_TEXTURE_2D, texName[1]);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo2->bmiHeader.biWidth,
		TexInfo2->bmiHeader.biHeight, 0, GL_BGR_EXT, GL_UNSIGNED_BYTE, TexBits2);
	glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);


	glBindTexture(GL_TEXTURE_2D, texName[2]);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo3->bmiHeader.biWidth, TexInfo3->bmiHeader.biHeight, 0, GL_BGR_EXT, GL_UNSIGNED_BYTE, TexBits3);
	glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	glBindTexture(GL_TEXTURE_2D, texName[3]);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo4->bmiHeader.biWidth, TexInfo4->bmiHeader.biHeight, 0, GL_BGR_EXT, GL_UNSIGNED_BYTE, TexBits4);
	glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);


	glBindTexture(GL_TEXTURE_2D, texName[4]);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo5->bmiHeader.biWidth, TexInfo5->bmiHeader.biHeight, 0, GL_BGR_EXT, GL_UNSIGNED_BYTE, TexBits5);
	glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	glBindTexture(GL_TEXTURE_2D, texName[5]);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo6->bmiHeader.biWidth, TexInfo6->bmiHeader.biHeight, 0, GL_BGR_EXT, GL_UNSIGNED_BYTE, TexBits6);
	glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);


	glEnable(GL_TEXTURE_2D);
}
GLvoid glDrawCube(){

	glBindTexture(GL_TEXTURE_2D, texName[0]);
	glBegin(GL_QUADS);
	// Front Face
	glNormal3f(0.0f, 0.0f, 0.5f);
	glTexCoord2f(0.0f, 0.0f); glVertex3f(-1.0f, -1.0f, 1.0f);
	glTexCoord2f(1.0f, 0.0f); glVertex3f(1.0f, -1.0f, 1.0f);
	glTexCoord2f(1.0f, 1.0f); glVertex3f(1.0f, 1.0f, 1.0f);
	glTexCoord2f(0.0f, 1.0f); glVertex3f(-1.0f, 1.0f, 1.0f);
	glEnd();

	glBindTexture(GL_TEXTURE_2D, texName[1]);
	glBegin(GL_QUADS);
	// Back Face
	glNormal3f(0.0f, 0.0f, -0.5f);
	glTexCoord2f(1.0f, 0.0f); glVertex3f(-1.0f, -1.0f, -1.0f);
	glTexCoord2f(1.0f, 1.0f); glVertex3f(-1.0f, 1.0f, -1.0f);
	glTexCoord2f(0.0f, 1.0f); glVertex3f(1.0f, 1.0f, -1.0f);
	glTexCoord2f(0.0f, 0.0f); glVertex3f(1.0f, -1.0f, -1.0f);
	glEnd();

	glBindTexture(GL_TEXTURE_2D, texName[3]);
	glBegin(GL_QUADS);
	// Top Face
	glNormal3f(0.0f, 0.5f, 0.0f);
	glTexCoord2f(0.0f, 1.0f); glVertex3f(-1.0f, 1.0f, -1.0f);
	glTexCoord2f(0.0f, 0.0f); glVertex3f(-1.0f, 1.0f, 1.0f);
	glTexCoord2f(1.0f, 0.0f); glVertex3f(1.0f, 1.0f, 1.0f);
	glTexCoord2f(1.0f, 1.0f); glVertex3f(1.0f, 1.0f, -1.0f);
	glEnd();

	glBindTexture(GL_TEXTURE_2D, texName[5]);
	glBegin(GL_QUADS);
	// Bottom Face
	glNormal3f(0.0f, -0.5f, 0.0f);
	glTexCoord2f(1.0f, 1.0f); glVertex3f(-1.0f, -1.0f, -1.0f);
	glTexCoord2f(0.0f, 1.0f); glVertex3f(1.0f, -1.0f, -1.0f);
	glTexCoord2f(0.0f, 0.0f); glVertex3f(1.0f, -1.0f, 1.0f);
	glTexCoord2f(1.0f, 0.0f); glVertex3f(-1.0f, -1.0f, 1.0f);
	glEnd();

	glBindTexture(GL_TEXTURE_2D, texName[2]);
	glBegin(GL_QUADS);
	// Right Face
	glNormal3f(0.5f, 0.0f, 0.0f);
	glTexCoord2f(1.0f, 0.0f); glVertex3f(1.0f, -1.0f, -1.0f);
	glTexCoord2f(1.0f, 1.0f); glVertex3f(1.0f, 1.0f, -1.0f);
	glTexCoord2f(0.0f, 1.0f); glVertex3f(1.0f, 1.0f, 1.0f);
	glTexCoord2f(0.0f, 0.0f); glVertex3f(1.0f, -1.0f, 1.0f);
	glEnd();

	glBindTexture(GL_TEXTURE_2D, texName[4]);
	glBegin(GL_QUADS);
	// Left Face
	glNormal3f(-0.5f, 0.0f, 0.0f);
	glTexCoord2f(0.0f, 0.0f); glVertex3f(-1.0f, -1.0f, -1.0f);
	glTexCoord2f(1.0f, 0.0f); glVertex3f(-1.0f, -1.0f, 1.0f);
	glTexCoord2f(1.0f, 1.0f); glVertex3f(-1.0f, 1.0f, 1.0f);
	glTexCoord2f(0.0f, 1.0f); glVertex3f(-1.0f, 1.0f, -1.0f);
	glEnd();

}

void display(void)
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glPushMatrix();
	glRotatef(xRot, 1.0, 0.0, -0.5);
	glRotatef(yRot, 0.0, 1.0, 0.0);
	glRotatef(zRot, -0.5, 0.0, 1.0);
	glDrawCube();
	glPopMatrix();
	glFlush();
}

void reshape(int w, int h)
{
	glViewport(0, 0, (GLsizei)w, (GLsizei)h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	if (w <= h)
		glOrtho(-2.6, 2.6, -2.60*(GLfloat)h / (GLfloat)w,
		2.60*(GLfloat)h / (GLfloat)w, -2.60, 2.60);
	else
		glOrtho(-2.60*(GLfloat)w / (GLfloat)h,
		2.60*(GLfloat)w / (GLfloat)h, -2.60, 2.60, -2.60, 2.60);
	glMatrixMode(GL_MODELVIEW);
}

void durdur(){
	x1rot = 0.0;
	y1rot = 0.0;
	z1rot = 0.0;

}

void rotate(){
	x1rot = 0.04;
	y1rot = 0.04;
	z1rot = 0.04;

}


void mouse(int button, int state, int x, int y){


	if (button == GLUT_LEFT_BUTTON){

		if (stop == 0){
			durdur();
			bas++;
		}
		if ((bas % 4) == 0){
			rotate();
			stop = 0;
		}
	}


}


void hesapla()

{
	xRot = xRot + x1rot;
	glutPostRedisplay();

	yRot = yRot + y1rot;
	glutPostRedisplay();

	zRot = zRot + z1rot;
	glutPostRedisplay();

}

void gosterim(void)
{
	glClear(GL_COLOR_BUFFER_BIT);
	glLoadIdentity();
	hesapla();
	display();

	glutSwapBuffers();
}




int main(int argc, char** argv){
	TexBits = LoadDIBitmap("1.bmp", &TexInfo);
	TexBits2 = LoadDIBitmap("2.bmp", &TexInfo2);
	TexBits3 = LoadDIBitmap("3.bmp", &TexInfo3);
	TexBits4 = LoadDIBitmap("4.bmp", &TexInfo4);
	TexBits5 = LoadDIBitmap("5.bmp", &TexInfo5);
	TexBits6 = LoadDIBitmap("6.bmp", &TexInfo6);
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(500, 500);
	glutCreateWindow(argv[0]);
	init();
	glutReshapeFunc(reshape);
	glutDisplayFunc(gosterim);
	glutMouseFunc(mouse);
	glutMainLoop();
	return 0;
}