import re, html
from pathlib import Path
import markdown

ROOT = Path(".")
CODE_EXT = {".py", ".java", ".cpp", ".c", ".js", ".ts", ".cs", ".go", ".kt", ".rb", ".swift", ".rs", ".sql"}

def num(p):
    return int(re.match(r"(\d+)-", p.name).group(1))

folders = sorted(
    [d for d in ROOT.iterdir() if d.is_dir() and re.match(r"\d+-", d.name)],
    key=num,
)

parts, toc = [], []
for d in folders:
    title = d.name.split("-", 1)[1].replace("-", " ").title()
    anchor = f"p{num(d)}"
    toc.append(f'<li><a href="#{anchor}">{num(d)}. {title}</a></li>')

    readme = next(d.glob("README.md"), None)
    problem = markdown.markdown(readme.read_text(encoding="utf-8", errors="ignore"),
                                extensions=["fenced_code"]) if readme else "<p><i>No problem statement.</i></p>"

    solutions = ""
    for f in sorted(d.iterdir()):
        if f.suffix.lower() in CODE_EXT:
            code = html.escape(f.read_text(encoding="utf-8", errors="ignore"))
            solutions += f"<h3>Solution ({f.suffix[1:]})</h3><pre>{code}</pre>"

    parts.append(f'<section id="{anchor}"><h1>{num(d)}. {title}</h1>'
                 f'<h2>Problem</h2>{problem}<h2>Solution</h2>{solutions or "<p>No code found.</p>"}</section>')

css = """
@page { size: A4; margin: 15mm; @bottom-center { content: counter(page); font-size: 9pt; } }
body { font-family: sans-serif; font-size: 10pt; }
section { page-break-before: always; }
h1 { font-size: 16pt; border-bottom: 2px solid #333; }
pre { background: #f4f4f4; padding: 8px; font-size: 8.5pt; white-space: pre-wrap; word-wrap: break-word; }
"""
doc = f"<html><head><meta charset='utf-8'><style>{css}</style></head><body>" \
      f"<h1>DSA Revision Notes</h1><ol>{''.join(toc)}</ol>{''.join(parts)}</body></html>"

Path("DSA_Revision.html").write_text(doc, encoding="utf-8")
print("Done: DSA_Revision.html")