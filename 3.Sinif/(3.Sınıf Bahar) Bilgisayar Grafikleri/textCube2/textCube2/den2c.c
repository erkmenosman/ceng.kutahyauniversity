/*********************COMPLETALY OK***/


#include <stdlib.h>
//#include <stdio.h>
#include <glut.h>
#include <math.h>
#include "bitmap.c"	

BITMAPINFO *TexInfo,*TexInfo2; /* Texture bitmap information */
GLubyte    *TexBits, *TexBits2; /* Texture bitmap pixel bits */
static GLuint texName[2];

GLfloat LightAmbient[]=		{ 0.5f, 0.5f, 0.5f, 1.0f };
GLfloat LightDiffuse[]=		{ 1.0f, 1.0f, 1.0f, 1.0f };
GLfloat LightPosition[]=	{ 0.0f, 0.0f, 2.0f, 1.0f };

GLuint	filter;				// Which Filter To Use
GLuint	texture[6];			// Storage For 6 Textures (MODIFIED)
GLuint  object=1;			// Which Object To Draw



GLint spinx = 0;
GLint spiny = 0;


GLubyte *LoadDIBitmap(const char *filename,BITMAPINFO **info);    
void init(void) 
{
//glShadeModel(GL_SMOOTH);
glClearColor(0.0, 1.0, 1.0, 0.0);
	glEnable(GL_DEPTH_TEST);							// Enables Depth Testing
	glDepthFunc(GL_LEQUAL);								// The Type Of Depth Testing To Do
	glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);	// Really Nice Perspective Calculations
glLightfv(GL_LIGHT1, GL_AMBIENT, LightAmbient);		// Setup The Ambient Light
glLightfv(GL_LIGHT1, GL_DIFFUSE, LightDiffuse);		// Setup The Diffuse Light
glLightfv(GL_LIGHT1, GL_POSITION,LightPosition);	// Position The Light
glEnable(GL_LIGHT1);
//glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_SPHERE_MAP);
//glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_SPHERE_MAP);

			// Create Texture Coords 


glGenTextures(2, texName);
glBindTexture(GL_TEXTURE_2D, texName[0]);
//glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		//	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo->bmiHeader.biWidth,
					 TexInfo->bmiHeader.biHeight, 0, GL_BGR_EXT,
			 GL_UNSIGNED_BYTE, TexBits);

			glBindTexture(GL_TEXTURE_2D, texName[1]);
//glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
			//glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
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
		 glVertex3f(-1.0f, -1.0f,  1.0f);
		 glVertex3f( 1.0f, -1.0f,  1.0f);
		 glVertex3f( 1.0f,  1.0f,  1.0f);
		 glVertex3f(-1.0f,  1.0f,  1.0f);
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
		 glVertex3f(-1.0f,  1.0f, -1.0f);
		 glVertex3f(-1.0f,  1.0f,  1.0f);
		 glVertex3f( 1.0f,  1.0f,  1.0f);
		 glVertex3f( 1.0f,  1.0f, -1.0f);
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
   glLoadIdentity();		
   glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_SPHERE_MAP); 
glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_SPHERE_MAP); 
glEnable(GL_TEXTURE_GEN_S);
glEnable(GL_TEXTURE_GEN_T);

   /*glEnable(GL_TEXTURE_GEN_S);							// Enable Texture Coord Generation For S (NEW)
	glEnable(GL_TEXTURE_GEN_T);
	glBindTexture(GL_TEXTURE_2D, texName[0]);*/
   glPushMatrix ();
   glRotatef ((GLfloat) spinx, 1.0, 0.0, 0.0);
   glRotatef ((GLfloat) spiny, 0.0, 0.0, 1.0);
		glDrawCube();
    glPopMatrix ();

	glDisable(GL_TEXTURE_GEN_S);
	glDisable(GL_TEXTURE_GEN_T);
	glBindTexture(GL_TEXTURE_2D, texName[1]);	// This Will Select The BG Maps...
	glPushMatrix();
		glTranslatef(0.0f, 0.0f, 0.0f);
		glBegin(GL_QUADS);
			glNormal3f( 0.0f, 0.0f, 1.0f);
			glTexCoord2f(0.0f, 0.0f); glVertex3f(-13.3f, -10.0f,  -10.0f);
			glTexCoord2f(1.0f, 0.0f); glVertex3f( 13.3f, -10.0f,  -10.0f);
			glTexCoord2f(1.0f, 1.0f); glVertex3f( 13.3f,  10.0f,  -10.0f);
			glTexCoord2f(0.0f, 1.0f); glVertex3f(-13.3f,  10.0f,  -10.0f);
		glEnd();
	glPopMatrix();


    glFlush ();
}

/*  call when window is resized  */
void reshape(int w, int h)
{
    glViewport (0, 0, (GLsizei) w, (GLsizei) h);
   glMatrixMode (GL_PROJECTION);
   glLoadIdentity ();

   if (w <= h)
      glOrtho (-13.0, 13.0, -10.0*(GLfloat)h/(GLfloat)w,
         10.0*(GLfloat)h/(GLfloat)w, -10.0, 10.0);
   else
      glOrtho (-13.0*(GLfloat)w/(GLfloat)h,
         13.0*(GLfloat)w/(GLfloat)h, -10.0, 10.0, -10.0, 10.0);

   glMatrixMode(GL_MODELVIEW);  
}

/*  call when mouse button is prespringsed  */
void mouse(int button, int state, int x, int y) {
    switch (button) {
	case GLUT_LEFT_BUTTON:
	    switch (state) {
		case GLUT_DOWN:
		    spinx = (spinx + 5) % 360; 
                    glutPostRedisplay();
		    break;
		default:
		    break;
            }
            break;
	case GLUT_MIDDLE_BUTTON:
	    switch (state) {
		case GLUT_DOWN:
		    spiny = (spiny + 5) % 360; 
                    glutPostRedisplay();
		    break;
		default:
		    break;
            }
            break;
	case GLUT_RIGHT_BUTTON:
	    switch (state) {
		case GLUT_UP:
		    exit(0);
		    break;
		default:
		    break;
            }
            break;
        default:
            break;
    }
}



int main(int argc, char** argv)
{
TexBits = LoadDIBitmap("marble.bmp", &TexInfo);
TexBits2 = LoadDIBitmap("Reflect.bmp", &TexInfo2);


    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
glutInitWindowSize(500, 500);

    glutCreateWindow(argv[0]);
init();
    glutReshapeFunc(reshape);
    glutDisplayFunc(display);
    glutMouseFunc(mouse);

    glutMainLoop();
    return 0;
}



