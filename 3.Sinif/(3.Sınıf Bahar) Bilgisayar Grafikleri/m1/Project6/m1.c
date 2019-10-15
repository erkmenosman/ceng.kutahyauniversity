/*********************COMPLETALY OK***/


#include <stdlib.h>
#include <glut.h>
#include <math.h>
#include "balon.c"
#include "dinazor.c"
//#include "limon.c"
//#include "kap.c"
//#include "balik.c"
//#include "sopa.c"
//#include "top.c"



float xRot = 0;
float yRot = 0;
float zRot = 0;
int xAbs, yAbs;


GLint spinx = 0;
GLint spiny = 0;


void init(void)
{
	glShadeModel(GL_SMOOTH);
	glClearColor(0.0, 1.0, 1.0, 0.0);

	GLfloat glfLightAmbient[] = { 0.1f, 0.1f, 0.1f, 1.0f };
	GLfloat glfLightDiffuse[] = { 1.2f, 1.2f, 1.2f, 1.0f };
	GLfloat glfLightSpecular[] = { 0.9f, 0.9f, 0.9f, 1.0f };

	glLightfv(GL_LIGHT0, GL_AMBIENT, glfLightAmbient);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, glfLightDiffuse);
	glLightfv(GL_LIGHT0, GL_SPECULAR, glfLightSpecular);
	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);

	glEnable(GL_DEPTH_TEST);
	glEnable(GL_CULL_FACE);

}/*end initial*/

GLvoid glDrawCube()
{
	/*
	glBegin(GL_QUADS);
	// Front Face
	glNormal3f(0.0f, 0.0f, 0.5f);
	glVertex3f(-1.0f, -1.0f, 1.0f);
	glVertex3f(1.0f, -1.0f, 1.0f);
	glVertex3f(1.0f, 1.0f, 1.0f);
	glVertex3f(-1.0f, 1.0f, 1.0f);
	// Back Face
	glNormal3f(0.0f, 0.0f, -0.5f);
	glVertex3f(-1.0f, -1.0f, -1.0f);
	glVertex3f(-1.0f, 1.0f, -1.0f);
	glVertex3f(1.0f, 1.0f, -1.0f);
	glVertex3f(1.0f, -1.0f, -1.0f);
	glEnd();

	glBegin(GL_QUADS);
	// Top Face
	glNormal3f(0.0f, 0.5f, 0.0f);
	glVertex3f(-1.0f, 1.0f, -1.0f);
	glVertex3f(-1.0f, 1.0f, 1.0f);
	glVertex3f(1.0f, 1.0f, 1.0f);
	glVertex3f(1.0f, 1.0f, -1.0f);
	// Bottom Face
	glNormal3f(0.0f, -0.5f, 0.0f);
	glVertex3f(-1.0f, -1.0f, -1.0f);
	glVertex3f(1.0f, -1.0f, -1.0f);
	glVertex3f(1.0f, -1.0f, 1.0f);
	glVertex3f(-1.0f, -1.0f, 1.0f);
	glEnd();

	glBegin(GL_QUADS);
	// Right Face
	glNormal3f(0.5f, 0.0f, 0.0f);
	glVertex3f(1.0f, -1.0f, -1.0f);
	glVertex3f(1.0f, 1.0f, -1.0f);
	glVertex3f(1.0f, 1.0f, 1.0f);
	glVertex3f(1.0f, -1.0f, 1.0f);
	// Left Face
	glNormal3f(-0.5f, 0.0f, 0.0f);
	glVertex3f(-1.0f, -1.0f, -1.0f);
	glVertex3f(-1.0f, -1.0f, 1.0f);
	glVertex3f(-1.0f, 1.0f, 1.0f);
	glVertex3f(-1.0f, 1.0f, -1.0f);
	glEnd();
	*/
	//balon();
	dinazor();

	//limon();
	//kap();++
	//balik();++
	//sopa();++
	//top();++
	
	
}

void display(void)
{

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glPushMatrix();
	glRotatef(xRot, 1.0f, 0.0f, 0.0f);
	glRotatef(yRot, 0.0f, 1.0f, 0.0f);
	glRotatef(zRot, 0.0f, 0.0f, 1.0f);
	glDrawCube();
	glPopMatrix();
	glFlush();
}

/*  call when window is resized  */
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

/*  call when mouse button is prespringsed  */
void MouseMove(int x, int y)
{
	
	xRot += (y - yAbs);	        // turn left or right 
	yAbs = y;					// refresh our x value

	yRot += (x - xAbs);	        // rotate up or down
	xAbs = x;					// refresh our y value

	// Check x,y rotation values to keep 0-355
	if (xRot > 360.0f)
		xRot -= 360.0f;

	if (xRot < 0.0f)
		xRot += 360.0f;

	if (yRot > 360.0f)
		yRot -= 360.0f;

	if (yRot < 0.0f)
		yRot += 360.0f;

	// Refresh the window
	glutPostRedisplay();
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(500, 500);

	glutCreateWindow(argv[0]);
	init();
	glutReshapeFunc(reshape);
	glutDisplayFunc(display);
	//glutMouseFunc(MouseMove);
	glutMotionFunc(MouseMove);
	glutMainLoop();
	return 0;
}



