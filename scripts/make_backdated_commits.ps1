Param(
    [string]$StartDate = '2025-11-15',
    [string]$EndDate = '2025-12-27',
    [string]$FilePath = 'HEATMAP.md'
)
# Move to repository root
$repoRoot = git rev-parse --show-toplevel 2>$null
if (-not $repoRoot) { Write-Error "Not inside a git repository."; exit 1 }
Set-Location $repoRoot

# Stash any local changes to avoid conflicts
$stashed = $false
if (git status --porcelain) { git stash push -u -m 'autostash-heatmap' | Out-Null; $stashed = $true }

$start = Get-Date $StartDate
$end = Get-Date $EndDate
for ($d = $start; $d -le $end; $d = $d.AddDays(1)) {
    $s = $d.ToString('yyyy-MM-dd')
    $commitCount = Get-Random -Minimum 12 -Maximum 18  # 12-17 commits per day
    for ($i = 1; $i -le $commitCount; $i++) {
        # Make a tiny, meaningful edit
        $line = "$s [commit $i/$commitCount] - activity record"
        Add-Content -Path $FilePath -Value $line
        git add $FilePath
        $hour = Get-Random -Minimum 0 -Maximum 24
        $minute = Get-Random -Minimum 0 -Maximum 60
        $dateStr = "$($d.ToString('yyyy-MM-dd')) $($hour.ToString('00')):$($minute.ToString('00')):00 +0000"
        $env:GIT_AUTHOR_DATE = $dateStr
        $env:GIT_COMMITTER_DATE = $dateStr
        git commit -m "chore(heatmap): activity for $s [$i]" --no-verify | Out-Null
        Remove-Item env:GIT_AUTHOR_DATE -ErrorAction SilentlyContinue
        Remove-Item env:GIT_COMMITTER_DATE -ErrorAction SilentlyContinue
    }
}

if ($stashed) {
    git stash pop --index | Out-Null
}
Write-Output "Done: created commits from $StartDate to $EndDate and updated $FilePath"