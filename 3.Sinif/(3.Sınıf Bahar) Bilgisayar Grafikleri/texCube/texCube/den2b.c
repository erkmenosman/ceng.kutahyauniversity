/*********************COMPLETALY OK***/


#include <stdlib.h>
//#include <stdio.h>
#include <glut.h>
#include <math.h>
#include "bitmap.c"	

BITMAPINFO *TexInfo,*TexInfo2; /* Texture bitmap information */
GLubyte    *TexBits, *TexBits2; /* Texture bitmap pixel bits */
static GLuint texName[2];

float xRot=0;
float yRot=0;
float zRot=0;
int xAbs,yAbs;	


GLint spinx = 0;
GLint spiny = 0;


GLubyte *LoadDIBitmap(const char *filename,BITMAPINFO **info);    
void init(void) 
{
glEnable(GL_DEPTH_TEST);
glShadeModel(GL_SMOOTH);
glClearColor(0.0, 1.0, 1.0, 0.0);

glGenTextures(2, texName);
glBindTexture(GL_TEXTURE_2D, texName[0]);
//glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
//			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo->bmiHeader.biWidth,
					 TexInfo->bmiHeader.biHeight, 0, GL_BGR_EXT,
			 GL_UNSIGNED_BYTE, TexBits);
   glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

glBindTexture(GL_TEXTURE_2D, texName[1]);
//glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
//			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo2->bmiHeader.biWidth,
					 TexInfo2->bmiHeader.biHeight, 0, GL_BGR_EXT,
			 GL_UNSIGNED_BYTE, TexBits2);
   glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

glEnable(GL_TEXTURE_2D);
}/*end initial*/

GLvoid glDrawCube()
{
	   glBindTexture(GL_TEXTURE_2D, texName[0]);
		glBegin(GL_QUADS);
		// Front Face
		glNormal3f( 0.0f, 0.0f, 0.5f);
		glTexCoord2f(0.0f, 0.0f); glVertex3f(-1.0f, -1.0f,  1.0f);
		glTexCoord2f(1.0f, 0.0f); glVertex3f( 1.0f, -1.0f,  1.0f);
		glTexCoord2f(1.0f, 1.0f); glVertex3f( 1.0f,  1.0f,  1.0f);
		glTexCoord2f(0.0f, 1.0f); glVertex3f(-1.0f,  1.0f,  1.0f);
		// Back Face
		glNormal3f( 0.0f, 0.0f,-0.5f);
		glTexCoord2f(1.0f, 0.0f); glVertex3f(-1.0f, -1.0f, -1.0f);
		glTexCoord2f(1.0f, 1.0f); glVertex3f(-1.0f,  1.0f, -1.0f);
		glTexCoord2f(0.0f, 1.0f); glVertex3f( 1.0f,  1.0f, -1.0f);
		glTexCoord2f(0.0f, 0.0f); glVertex3f( 1.0f, -1.0f, -1.0f);
 glEnd();
		glBindTexture(GL_TEXTURE_2D, texName[1]);
		glBegin(GL_QUADS);
		// Top Face
		glNormal3f( 0.0f, 0.5f, 0.0f);
		glTexCoord2f(0.0f, 1.0f); glVertex3f(-1.0f,  1.0f, -1.0f);
		glTexCoord2f(0.0f, 0.0f); glVertex3f(-1.0f,  1.0f,  1.0f);
		glTexCoord2f(1.0f, 0.0f); glVertex3f( 1.0f,  1.0f,  1.0f);
		glTexCoord2f(1.0f, 1.0f); glVertex3f( 1.0f,  1.0f, -1.0f);
		// Bottom Face
		glNormal3f( 0.0f,-0.5f, 0.0f);
		glTexCoord2f(1.0f, 1.0f); glVertex3f(-1.0f, -1.0f, -1.0f);
		glTexCoord2f(0.0f, 1.0f); glVertex3f( 1.0f, -1.0f, -1.0f);
		glTexCoord2f(0.0f, 0.0f); glVertex3f( 1.0f, -1.0f,  1.0f);
		glTexCoord2f(1.0f, 0.0f); glVertex3f(-1.0f, -1.0f,  1.0f);
	glEnd();
		glBindTexture(GL_TEXTURE_2D, texName[0]);
		glBegin(GL_QUADS);
		// Right Face
		glNormal3f( 0.5f, 0.0f, 0.0f);
		glTexCoord2f(1.0f, 0.0f); glVertex3f( 1.0f, -1.0f, -1.0f);
		glTexCoord2f(1.0f, 1.0f); glVertex3f( 1.0f,  1.0f, -1.0f);
		glTexCoord2f(0.0f, 1.0f); glVertex3f( 1.0f,  1.0f,  1.0f);
		glTexCoord2f(0.0f, 0.0f); glVertex3f( 1.0f, -1.0f,  1.0f);
		// Left Face
		glNormal3f(-0.5f, 0.0f, 0.0f);
		glTexCoord2f(0.0f, 0.0f); glVertex3f(-1.0f, -1.0f, -1.0f);
		glTexCoord2f(1.0f, 0.0f); glVertex3f(-1.0f, -1.0f,  1.0f);
		glTexCoord2f(1.0f, 1.0f); glVertex3f(-1.0f,  1.0f,  1.0f);
		glTexCoord2f(0.0f, 1.0f); glVertex3f(-1.0f,  1.0f, -1.0f);
	glEnd();
}

void display (void)
{

   glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glPushMatrix ();
		glRotatef(xRot, 1.0f, 0.0f, 0.0f);
		glRotatef(yRot, 0.0f, 1.0f, 0.0f);
		glRotatef(zRot, 0.0f, 0.0f, 1.0f);
		glDrawCube();
    glPopMatrix ();
    glFlush ();
}

/*  call when window is resized  */
void reshape(int w, int h)
{
    glViewport (0, 0, (GLsizei) w, (GLsizei) h);
   glMatrixMode (GL_PROJECTION);
   glLoadIdentity ();

   if (w <= h)
      glOrtho (-2.6, 2.6, -2.60*(GLfloat)h/(GLfloat)w,
         2.60*(GLfloat)h/(GLfloat)w, -2.60, 2.60);
   else
      glOrtho (-2.60*(GLfloat)w/(GLfloat)h,
         2.60*(GLfloat)w/(GLfloat)h, -2.60, 2.60, -2.60, 2.60);

   glMatrixMode(GL_MODELVIEW);  
}

/*  call when mouse button is prespringsed  */
void MouseMove (int x, int y)
{
	// the x and y values affect the opposite axis values
	// because each is rotation "about an axis", not in a direction
	xRot += (y-yAbs);	// turn left or right 
	yAbs = y;					// refresh our x value
	
	yRot += (x-xAbs);	// rotate up or down
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
TexBits = LoadDIBitmap("marble.bmp", &TexInfo);
TexBits2 = LoadDIBitmap("skin02.bmp", &TexInfo2);


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



